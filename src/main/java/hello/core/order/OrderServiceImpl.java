package hello.core.order;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

//  private MemberRepository memberRepository;
//  private DiscountPolicy discountPolicy;

//  @Autowired private MemberRepository memberRepository;
//  @Autowired private DiscountPolicy discountPolicy;

//  @Autowired(required = false)
//  public void setMemberRepository(MemberRepository memberRepository) {
//    System.out.println("memberRepository = " + memberRepository);
//    this.memberRepository = memberRepository;
//  }
////
//  @Autowired
//  public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//    System.out.println("discountPolicy = " + discountPolicy);
//    this.discountPolicy = discountPolicy;
//  }

//  @Autowired // 생성자는 @Autowired 굳이 써줄 필요 없다. (생성자는 @RequiredArgsConstructor에 의해 롬복이 final을 보고 자동 생성 : cmd + F12로 확인해보자)
//  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//    System.out.println("1. OrderServiceImpl.OrderServiceImpl");
//    this.memberRepository = memberRepository;
//    this.discountPolicy = discountPolicy;
//  }

//  @Autowired
//  void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//    this.memberRepository = memberRepository;
//    this.discountPolicy = discountPolicy;
//  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  // 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}

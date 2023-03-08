package hello.core.member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component // 스프링컨테이너에 등록되는 이름 : memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository {
  private static Map<Long, Member> store = new HashMap<>();
  @Override
  public void save(Member member) {
    store.put(member.getId(), member);
  }
  @Override
  public Member findById(Long memberId) {
    return store.get(memberId);
  }
}

package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //key-value 형태를 가지고 1:1 매핑
    private static Long sequence = 0L;  // L이라고 붙은 것은 Long형 값이라는 의미

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //결과가 null 이 되는 것을 방지
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  //루프로 돌림
                .filter(member -> member.getName().equals(name))  //람다 사용
                .findAny();  //하나라도 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}

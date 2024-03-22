package homework.study_homework.repository;

import homework.study_homework.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    private static Long sequence = 1L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        return store.values().stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByMemberName(String memberName) {
        return store.values().stream()
                .filter(m -> m.getMemberName().equals(memberName))
                .findAny();
    }
}

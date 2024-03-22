package homework.study_homework.repository;

import homework.study_homework.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    //Member updateMemberNameAndMemberAge(Member member, String newMemberName, Long newMemberAge);
    Optional<Member> findById(Long id);
    Optional<Member> findByMemberId(String memberId);
    Optional<Member> findByMemberName(String memberName);
    List<Member> findAll();
}

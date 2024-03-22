package homework.study_homework.repository;

import homework.study_homework.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    @Override
    Optional<Member> findByMemberName(String name);
}

package homework.study_homework.service;

import homework.study_homework.domain.Member;
import homework.study_homework.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    };

    public Long join(Member member){
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByMemberName(member.getMemberName())
                .ifPresent(m -> {
                    new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //public void updateMember(Member member) {
    //    memberRepository.save(member); // JpaRepository의 save() 메서드를 사용하여 회원 정보 업데이트
    //}

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findMember(String memberId){
        return memberRepository.findByMemberId(memberId);
    }


    public Member updateMember(Member member, String newMemberName, Long newMemberAge){
        Optional<Member> updateMember_ = findMember(member.getMemberName());

        if(updateMember_.isPresent()){
            Member updateMember = updateMember_.get();
            updateMember.setMemberName(newMemberName);
            updateMember.setMemberAge(newMemberAge);
            return memberRepository.save(updateMember);
        }else{
            return null;
        }
    }




}

package homework.study_homework.controller;

import homework.study_homework.domain.Member;
import homework.study_homework.form.MemberForm;
import homework.study_homework.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



    @GetMapping("/members/new") // 도메인 첫 번째
    public String createForm(){
        return "members/createMemberForm"; // home.html
    }

    @PostMapping("/members/new")
    public String crate(MemberForm form){
        Member member = new Member();
        member.setMemberName(form.getMemberName());
        member.setMemberAge(form.getMemberAge());
        member.setMemberId(form.getMemberId());
        member.setMemberPassword(form.getMemberPassword());

        memberService.join(member);

        return "redirect:/"; // 홈 화면으로 보낸다
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping("/members/memberLogin")
    public String memberMain(@RequestParam(value = "memberId") String memberId, @RequestParam(value = "password") String password, Model model){
        Optional<Member> member = memberService.findMember(memberId);
        if(member.isPresent()){
            Member findMember = member.get();

            if(password.equals(findMember.getMemberPassword())){
                // 아이디 비밀번호 다 맞았을 시
                model.addAttribute("member", findMember);
                model.addAttribute("memberId", memberId);
                return "Home";
            }
            else{
                // 비밀번호 틀렸을 시
                return "redirect:/";
            }
        }
        else{
            // 로그인 실패 시 원래 화면
            return "redirect:/";
        }

    }
    /*
    @GetMapping("/members/update")
    public String updateForm(){
        return "members/updateMemberForm";
    }
    */

    @GetMapping("/members/update")
    public String updateForm(@RequestParam(value = "memberId") String memberId, Model model) {
        model.addAttribute("memberId", memberId);
        return "members/updateMemberForm";
    }

    @PostMapping("/members/update")
    public String update(@RequestParam(value = "updateName") String updateMemberName,
                         @RequestParam(value = "updateAge") long updateAge,
                         @RequestParam(value = "memberId") String memberId){
        Optional<Member> findMember = memberService.findMember(memberId);
        if (findMember.isPresent()) {
            Member member = findMember.get();
            // 회원 정보 업데이트
            member.setMemberName(updateMemberName);
            member.setMemberAge(updateAge);
            memberService.updateMember(member, updateMemberName, updateAge);
        }
        return "redirect:/";
    }





}

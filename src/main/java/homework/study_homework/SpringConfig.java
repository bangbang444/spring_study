package homework.study_homework;


import homework.study_homework.repository.MemberRepository;
import homework.study_homework.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;


    @Autowired
    public SpringConfig(EntityManager em, MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

}

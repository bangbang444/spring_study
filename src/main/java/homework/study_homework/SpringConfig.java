package homework.study_homework;


import homework.study_homework.repository.SelfRepository;
import homework.study_homework.service.SelfService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final SelfRepository selfRepository;


    @Autowired
    public SpringConfig(EntityManager em, SelfRepository selfRepository) {
        this.selfRepository = selfRepository;
    }

    @Bean
    public SelfService selfService(){
        return new SelfService(selfRepository);

    }

}

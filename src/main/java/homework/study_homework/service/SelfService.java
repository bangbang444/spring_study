package homework.study_homework.service;

import homework.study_homework.domain.Self;
import homework.study_homework.repository.SelfRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class SelfService {
    private final SelfRepository selfRepository;


    public SelfService(SelfRepository selfRepository) {
        this.selfRepository = selfRepository;
    }

    public Long selfAppend(Self self){
        selfRepository.save(self);
        return self.getId();
    }

    public List<Self> findSelfs(){
        return selfRepository.findAll();
    }

    public Optional<Self> findOne(Long selfId){
        return selfRepository.findById(selfId);
    }
}

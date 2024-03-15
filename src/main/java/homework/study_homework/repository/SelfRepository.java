package homework.study_homework.repository;

import homework.study_homework.domain.Self;

import java.util.List;
import java.util.Optional;

public interface SelfRepository {

    Self save(Self self);
    Optional<Self> findById(Long id);
    Optional<Self> findByName(String name);

    List<Self> findAll();


}

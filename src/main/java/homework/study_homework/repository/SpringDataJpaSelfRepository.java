package homework.study_homework.repository;

import homework.study_homework.domain.Self;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaSelfRepository extends JpaRepository<Self, Long>, SelfRepository{

    @Override
    Optional<Self> findByName(String name);
}

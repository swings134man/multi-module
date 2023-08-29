package com.test.core.modules.test.repository;

import com.test.core.modules.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestJpaRepository extends JpaRepository<Test, Long>, TestCustomRepository{
    Test findByMessage(String message);
    Test findByMessageContaining(String message); //test

    // QueryDsl Test
    List<Test> findByCreatedDateBetween(String createdDate, String createdDate2);

    // condition get
    List<Test> getTest(Test test);
}

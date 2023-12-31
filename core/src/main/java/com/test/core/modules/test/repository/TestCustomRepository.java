package com.test.core.modules.test.repository;

import com.test.core.modules.test.domain.Test;

import java.util.List;

public interface TestCustomRepository {

    // QueryDsl Test
    List<Test> findByCreatedDateBetween(String createdDate, String createdDate2);

    List<Test> getTest(Test test);
}

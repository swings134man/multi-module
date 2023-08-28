package com.test.core.modules.test.repository;

import com.test.core.modules.test.domain.Test;

import java.util.List;

public interface TestCustomRepository {
    // QueryDsl Test
//    List<Test> findByCreatedDate(String starDt, String endDt);
    List<Test> findByCreatedDateBetween(String createdDate, String createdDate2);
}

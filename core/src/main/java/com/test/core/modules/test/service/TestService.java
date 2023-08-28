package com.test.core.modules.test.service;

import com.test.core.modules.test.domain.Test;
import com.test.core.modules.test.repository.TestJpaRepository;
import com.test.core.modules.test.repository.TestRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final TestJpaRepository testRepository;

    public String test(String message) {
        Test result = testRepository.findByMessageContaining(message);
        return result.getMessage();
    }

    @Transactional
    public Test testPost(String message) {
        Test test = new Test();
        test.setMessage(message);

        return testRepository.save(test);
    }

    @Transactional(readOnly = true)
    public List<Test> getListDate(String starDt, String endDt) {
        return testRepository.findByCreatedDateBetween(starDt, endDt);
    }
}

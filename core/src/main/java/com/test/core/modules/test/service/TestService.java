package com.test.core.modules.test.service;

import com.test.core.modules.test.domain.Test;
import com.test.core.modules.test.domain.TestDTO;
import com.test.core.modules.test.repository.TestJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final TestJpaRepository testRepository;
    private final ModelMapper modelMapper;

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

    @Transactional(readOnly = true)
    public List<Test> getTest(TestDTO dto) {
        Test test = modelMapper.map(dto, Test.class);
        return testRepository.getTest(test);
    }
}

package com.test.batch.rest;

import com.test.core.modules.test.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestClass {

    private final TestService testService;

    @GetMapping(value = "/{message}")
    public ResponseEntity<String> test(@PathVariable String message) {
        String result = testService.test(message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

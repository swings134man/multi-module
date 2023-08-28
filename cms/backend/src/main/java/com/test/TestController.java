package com.test;

import com.test.core.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping(value = "/{message}")
    public ResponseEntity<String> test(@PathVariable String message) {
        String result = testService.test(message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

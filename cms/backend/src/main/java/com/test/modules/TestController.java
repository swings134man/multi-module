package com.test.modules;

import com.test.core.modules.test.domain.Test;
import com.test.core.modules.test.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestService testService;

    @GetMapping(value = "/{message}")
    public ResponseEntity<String> test(@PathVariable String message) {
        String result = testService.test(message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/{message}")
    public ResponseEntity<Test> testPost(@PathVariable String message) {
        Test result = testService.testPost(message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/date")
    public ResponseEntity<List<Test>> getListDate(@RequestParam String starDt, @RequestParam String endDt) {
        List<Test> resultList = testService.getListDate(starDt, endDt);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }
}

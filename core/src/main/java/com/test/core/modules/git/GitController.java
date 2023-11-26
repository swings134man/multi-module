package com.test.core.modules.git;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/git")
public class GitController {

    private final GitService service;

    @GetMapping(value = "/get/", produces = "application/json")
    public ResponseEntity<Object> getBranch(@RequestParam String branchName) {
        Object branch = service.getBranch(branchName);
        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    @GetMapping(value = "/getBranches/", produces = "application/json")
    public ResponseEntity<List> getBranches() {
        List result = service.getBranches();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}

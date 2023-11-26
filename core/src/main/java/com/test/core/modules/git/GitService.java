package com.test.core.modules.git;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import org.springframework.http.HttpHeaders;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GitService {

    private final String GIT_URL = "https://api.github.com/repos/swings134man/multi-module";
    private final String GIT_TOKEN = "";

    private final RestTemplate restTemplate;

    public void getRepo() {
        log.info("getRepo");
    }

    public List getBranches() {
        log.info("getBranches");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(GIT_TOKEN);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, null, null);

        ResponseEntity<List> responseEntity = restTemplate.exchange(
                URI.create(GIT_URL + "/branches"),
                org.springframework.http.HttpMethod.GET,
                requestEntity,
                List.class
        );

        log.info("response = {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    public Object getBranch(String branchName) {
        log.info("getBranch");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(GIT_TOKEN);

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, null, null);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                URI.create(GIT_URL + "/branches/" + branchName),
                org.springframework.http.HttpMethod.GET,
                requestEntity,
                Object.class
        );

        log.info("response = {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

}

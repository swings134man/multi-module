package com.test.core.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    public String test(String message) {
        return message + " TEST SUCCESS!";
    }
}

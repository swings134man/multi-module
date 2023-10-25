package com.test.core.modules.test.service;

import com.test.core.modules.test.domain.Product;
import com.test.core.modules.test.repository.v2.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
        log.info("result: {}", product);
    }
}

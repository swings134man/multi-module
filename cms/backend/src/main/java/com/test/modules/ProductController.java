package com.test.modules;

import com.test.core.modules.test.domain.Product;
import com.test.core.modules.test.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/save")
    public ResponseEntity<Product> save(Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> result = productService.listProduct();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

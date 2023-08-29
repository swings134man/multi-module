package com.test.core.modules.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {

    private Long id;
    private String message;
    private String createdDate;
    private String updateDate;
}

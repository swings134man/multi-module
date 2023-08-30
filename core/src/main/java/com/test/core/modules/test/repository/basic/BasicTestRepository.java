package com.test.core.modules.test.repository.basic;

import com.test.core.modules.test.domain.Test;
import org.springframework.data.repository.Repository;

public interface BasicTestRepository extends Repository<Test, Long> {

    //for test
    Test findByMessage(String message);
}

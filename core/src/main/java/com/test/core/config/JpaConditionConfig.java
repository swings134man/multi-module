package com.test.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.Optional;


/**
 * Jpa Condition Config: JPA QueryDSL에서 where 조건을 사용하기 위한 설정
 */
@Configuration
public class JpaConditionConfig {

    @Bean
    public ConditionUtil conditionUtil() {
        return new ConditionUtil();
    }

    public class ConditionUtil {
        public <T> BooleanExpression condition(T value, Function<T, BooleanExpression> function) {
            return Optional.ofNullable(value).map(function).orElse(null);
        }
    }

}

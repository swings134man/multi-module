package com.test.core.modules.test.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.core.modules.test.domain.QTest;
import com.test.core.modules.test.domain.Test;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TestCustomRepositoryImpl implements TestCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Test> findByCreatedDateBetween(String starDt, String endDt) {
        return queryFactory.selectFrom(QTest.test)
                .where(
                        QTest.test.createdDate.between(starDt, endDt))
                .orderBy(QTest.test.createdDate.desc())
                .fetch();
    }
}

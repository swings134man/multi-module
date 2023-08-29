package com.test.core.modules.test.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.core.config.JpaConditionConfig;
import com.test.core.modules.test.domain.QTest;
import com.test.core.modules.test.domain.Test;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TestCustomRepositoryImpl implements TestCustomRepository {

    private final JPAQueryFactory queryFactory;
    private final JpaConditionConfig.ConditionUtil conditionUtil;

    @Override
    public List<Test> findByCreatedDateBetween(String starDt, String endDt) {
        return queryFactory.selectFrom(QTest.test)
                .where(
                        QTest.test.createdDate.between(starDt, endDt))
                .orderBy(QTest.test.createdDate.desc())
                .fetch();
    }

    // Condition get Test
    @Override
    public List<Test> getTest(Test test) {
        return queryFactory.select(QTest.test)
                .from(QTest.test)
                .where(
                        conditionUtil.condition(test.getId(), QTest.test.id::eq),
                        conditionUtil.condition(test.getMessage(), QTest.test.message::contains),
                        conditionUtil.condition(test.getCreatedDate(), QTest.test.createdDate::contains),
                        conditionUtil.condition(test.getUpdateDate(), QTest.test.updateDate::contains)
                )
                .fetch();
    }
}

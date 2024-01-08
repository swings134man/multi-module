package com.test.core.modules.dsl.middle_repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.core.modules.dsl.conf.Push;
import com.test.core.modules.dsl.conf.QPush;
import lombok.RequiredArgsConstructor;

import java.util.List;

/************
 * @info : Push Entity 기반 interface Impl class (QueryDsl)
 * @name : PushMidRepositoryImpl
 * @date : 1/8/24 10:30 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : QueryDsl을 사용한 실질적인 쿼리가 존재하는곳,,
 ************/
@RequiredArgsConstructor
public class PushMidRepositoryImpl implements PushMidRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Push> findByType(String type) {
        return queryFactory.selectFrom(QPush.push)
                .where(QPush.push.type.eq(type))
                .fetch();
    }
}

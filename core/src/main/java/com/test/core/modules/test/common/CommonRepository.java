package com.test.core.modules.test.common;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/************
 * @info : JPA Common Repository - for Extension
 * @name : CommonRepository
 * @date : 2023/10/25 12:03 AM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 *
 * EntityPathBase<T> : QueryDSL 을 사용하기 위한 EntityPathBase
 *
 * JpaRepository의 구현체이자, 실제 수행하는 SimpleJpaRepository를 상속받아서 사용
 *
 * QClass는 기본적으로 EntityPathBase를 상속받아서 사용하고 있음.
 *  - EntityPathBase는 기본적으로 QClass 에 어떤 Entity를 사용할지 정의해주는 역할을 함.
 *  - 이를 활용하여 동적인 쿼리 생성 가능.
 *
 ************/
@Repository
public abstract class CommonRepository<T, ID> extends SimpleJpaRepository<T, ID> {

    private final EntityPathBase<T> entity;

    private final JPAQueryFactory queryFactory;

    public CommonRepository(Class<T> clazz, EntityPathBase<T> entity, JPAQueryFactory queryFactory, EntityManager entityManager) {
        super(clazz, entityManager);
        this.entity = entity;
        this.queryFactory = queryFactory;
    }


    protected EntityPathBase<T> getEntity() {
        return entity;
    }

    protected JPAQueryFactory getQueryFactory() {
        return queryFactory;
    }
}

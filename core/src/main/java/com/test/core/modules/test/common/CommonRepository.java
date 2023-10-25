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

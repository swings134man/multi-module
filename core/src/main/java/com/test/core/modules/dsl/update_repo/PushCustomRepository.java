package com.test.core.modules.dsl.update_repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.core.modules.dsl.conf.Push;
import com.test.core.modules.dsl.conf.QPush;
import com.test.core.modules.test.common.CommonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/************
 * @info : QueryDsl + JpaRepository 사용 커스텀 클래스 예제
 * @name : PushCustomRepository
 * @date : 1/5/24 11:53 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Repository
@Slf4j
public class PushCustomRepository extends CommonRepository<Push, Long> {

    private final QPush push;

    private final JPAQueryFactory queryFactory;

    // Constructor
    public PushCustomRepository(JPAQueryFactory queryFactory, EntityManager entityManager) {
        super(Push.class, QPush.push, queryFactory, entityManager);
        this.push = (QPush) super.getEntity();
        this.queryFactory = super.getQueryFactory();
    }

    // Custom Method
    /**
     * 해당 커스텀 클래스의 경우, QueryDSL 및 JpaRepository를 사용가능하게 함.
     *
     */

    // basic 의 findByType 메소드와 동일한 기능
    public List<Push> cusFindByType(String type) {
        return queryFactory.selectFrom(push)
                .where(push.type.eq(type))
                .orderBy(push.id.desc())
                .fetch();
    }



}

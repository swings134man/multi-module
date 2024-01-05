package com.test.core.modules.dsl.conf;

import com.test.core.modules.dsl.basic_repo.PushBasicRepository;
import com.test.core.modules.dsl.update_repo.PushCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/************
 * @info : Push Entity 기반, QueryDsl 테스트 Service
 * @name : PushService
 * @date : 1/5/24 11:42 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Service
@RequiredArgsConstructor
@Slf4j
public class PushService {


    private final PushBasicRepository basicRepository; // JpaRepository 사용
    private final PushCustomRepository customRepository; // QueryDsl + JpaRepository 사용


    // ------------- BASIC -----------------
    /**
     *  1. JpaRepository 사용
     *  - 기본적인 CRUD 제공
     *  - 가장 보편적으로 많이 사용하는 JPA 인터페이스
     */

    @Transactional
    public void basicSave(Push push) {
        basicRepository.save(push);
        log.debug("PushService.basicSave : {}", push);
    }

    @Transactional(readOnly = true)
    public List<Push> basicFind() {
        List<Push> all = basicRepository.findAll();
        log.debug("PushService.basicFind : {}", all);

        return all;
    }

    @Transactional(readOnly = true)
    public void findByType(String type) {
        List<Push> all = basicRepository.findByType(type); // type으로 조회: Interface 정의 필요함.
        log.debug("PushService.findByType : {}", all);
    }

    // ------------- CUSTOM -----------------

    // JPARepositotry 의 기본 기능을 그대로 사용가능
    @Transactional
    public void cusSave(Push push) {
        customRepository.save(push);
        log.debug("PushService.cusSave : {}", push);
    }

    @Transactional(readOnly = true)
    public List<Push> findCusAll() {
        List<Push> all = customRepository.findAll();
        log.debug("PushService.findCusAll : {}", all);

        return all;
    }


    // QueryDsl 를 통한 DSL 쿼리 사용가능
    @Transactional(readOnly = true)
    public List<Push> cusFindByType(String type) {
        List<Push> pushes = customRepository.cusFindByType(type);
        log.debug("PushService.cusFindByType : {}", pushes);

        return pushes;
    }

}

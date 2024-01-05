package com.test.core.modules.dsl.basic_repo;

import com.test.core.modules.dsl.conf.Push;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;

/************
 * @info : JpaRepository 사용 (nomal)
 * @name : PushBasicRepository
 * @date : 1/5/24 11:46 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public interface PushBasicRepository extends JpaRepository<Push, Long> {
    List<Push> findByType(String type); // type으로 조회: Interface 정의 필요함.
}

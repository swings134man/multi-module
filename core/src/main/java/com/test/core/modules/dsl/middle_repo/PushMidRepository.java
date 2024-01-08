package com.test.core.modules.dsl.middle_repo;

import com.test.core.modules.dsl.conf.Push;

import java.util.List;

/************
 * @info : Push Entity 기반 interface
 * @name : PushMidRepository
 * @date : 1/8/24 10:27 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 
 ************/
public interface PushMidRepository {
    
    //
    List<Push> findByType(String type);
}

package com.test.core.modules.dsl.middle_repo;

import com.test.core.modules.dsl.conf.Push;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PushMidJpaRepository extends JpaRepository<Push, Long>, PushMidRepository {


}

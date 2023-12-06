package com.wide.cakeapplication.infrastructure.mysql.repository.cake;

import com.wide.cakeapplication.infrastructure.mysql.pojo.CakePO;
import com.wide.cakeapplication.infrastructure.mysql.pojo.EmployeePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CakeRepository extends JpaRepository<CakePO, Long> {
    List<CakePO> queryCakePOSByScope(String scope);

    @Query(nativeQuery = true,value = "select * from cake")
    List<CakePO> findAll();
}

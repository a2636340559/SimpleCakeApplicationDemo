package com.wide.cakeapplication.infrastructure.mysql.repository.employee;

import com.wide.cakeapplication.infrastructure.mysql.pojo.EmployeePO;
import com.wide.cakeapplication.infrastructure.mysql.pojo.MenuPO;
import com.wide.cakeapplication.infrastructure.mysql.pojo.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeePO, Long> {
    EmployeePO getEmployeePOByAccount(String account);
    void deleteEmployeePOByAccount(String account);
}

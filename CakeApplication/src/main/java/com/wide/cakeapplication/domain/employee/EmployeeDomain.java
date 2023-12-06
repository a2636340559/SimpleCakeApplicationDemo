package com.wide.cakeapplication.domain.employee;

import com.wide.cakeapplication.infrastructure.mysql.pojo.EmployeePO;
import com.wide.cakeapplication.infrastructure.mysql.repository.employee.EmployeeRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeDomain {
    @Resource
    EmployeeRepository employeeRepository;

    EmployeePO getEmployeeInfo(String userAccount) {
        Optional<EmployeePO> employeePOOptional = Optional.ofNullable(employeeRepository.getEmployeePOByAccount(userAccount));
        if (employeePOOptional.isEmpty()) {
            log.error("the account does not exist");
        }
        return employeePOOptional.orElse(null);
    }

    void deleteUser(String userAccount){
        try {
            employeeRepository.deleteEmployeePOByAccount(userAccount);
        }catch (Exception e){
            log.error("delete user failed:{}",e.getMessage(),e);
        }
    }


}

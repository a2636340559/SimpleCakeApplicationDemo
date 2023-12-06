package com.wide.cakeapplication.infrastructure.mysql.repository.role;

import com.wide.cakeapplication.infrastructure.mysql.pojo.RolePO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RolePO, Long> {

}

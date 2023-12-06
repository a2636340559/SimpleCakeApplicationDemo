package com.wide.cakeapplication.domain.role;

import com.wide.cakeapplication.infrastructure.mysql.pojo.RolePO;
import com.wide.cakeapplication.infrastructure.mysql.repository.role.RoleRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RoleDomain {
    @Resource
    RoleRepository roleRepository;

    public RolePO addRole(RolePO role) {
        Optional<RolePO> roleOptional = Optional.of(roleRepository.save(role));
       return roleOptional.get();
    }

    public void deleteRole(RolePO role) throws Exception{
        roleRepository.delete(role);
    }


}

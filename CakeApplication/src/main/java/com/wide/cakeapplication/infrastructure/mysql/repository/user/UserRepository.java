package com.wide.cakeapplication.infrastructure.mysql.repository.user;

import com.wide.cakeapplication.infrastructure.mysql.pojo.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPO, Long> {

    UserPO getUserPOByAccount(String account);
    void deleteUserPOByAccount(String account);
}

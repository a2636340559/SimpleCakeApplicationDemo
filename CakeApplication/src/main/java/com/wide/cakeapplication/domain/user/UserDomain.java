package com.wide.cakeapplication.domain.user;

import com.wide.cakeapplication.infrastructure.mysql.pojo.UserPO;
import com.wide.cakeapplication.infrastructure.mysql.repository.user.UserRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserDomain {
    @Resource
    UserRepository userRepository;

    UserPO getUserInfo(String userAccount) {
        Optional<UserPO> userOptional = Optional.ofNullable(userRepository.getUserPOByAccount(userAccount));
        if (userOptional.isEmpty()) {
            log.error("该用户不存在");
        }
        return userOptional.orElse(null);
    }

    void deleteUser(String userAccount){
        try {
            userRepository.deleteUserPOByAccount(userAccount);
        }catch (Exception e){
            log.error("delete user failed:{}",e.getMessage(),e);
        }
    }


}

package com.wide.cakeapplication.intefaces.assembler;

import com.wide.cakeapplication.infrastructure.constant.Constant;
import com.wide.cakeapplication.infrastructure.mysql.pojo.UserPO;
import com.wide.cakeapplication.intefaces.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;

public class UserTransfer {
    public static UserDTO toUserDTO(UserPO userPO) {
        return UserDTO.builder().userAccount(userPO.getAccount()).userIdentity(Constant.ROLES.get(userPO.getRoleId().toString())).build();
    }

    public static UserPO toUserPO(UserDTO userDTO) {
        return UserPO.builder()
                .id(userDTO.getUserId())
                .email(userDTO.getEmail())
                .avatar(userDTO.getAvatar())
                .account(userDTO.getUserAccount())
                .roleId(Long.valueOf(userDTO.getUserIdentity()))
                .name(userDTO.getUserName())
                .password(userDTO.getPassword()).build();
    }

    public static List<UserDTO> toUserDtoList(List<UserPO> list) {
        List<UserDTO> userDTOS = new ArrayList<>();
        list.forEach(bean -> {
            userDTOS.add(toUserDTO(bean));
        });
        return userDTOS;
    }
}

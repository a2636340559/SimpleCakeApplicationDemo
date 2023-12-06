package com.wide.cakeapplication.intefaces.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;


@Data
@Builder
public class UserDTO {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String avatar;
    private String userAccount;
    private String userIdentity;

}

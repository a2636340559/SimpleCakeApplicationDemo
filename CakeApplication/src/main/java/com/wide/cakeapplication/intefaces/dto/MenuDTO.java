package com.wide.cakeapplication.intefaces.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class MenuDTO {

    // the id of menu
    private Integer menuId;
    // the level of menu
    private Integer menuLevel;
    // parent menu id,default null ,that means this is a firstLevel menu
    private Long parentMenu;
    //the scope of menu (0:user;1:employee;2:special user)
    private String scope;
    // menu name
    private String menuName;
    // the uri or url of this menu
    private String url;
    // userAccount
    private String createUser;

}

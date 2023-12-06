package com.wide.cakeapplication.infrastructure.mysql.pojo;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@Table(name = "user")
@ToString
@Builder
@Entity
public class UserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String avatar;
    private String account;
    private String password;
    private Boolean isLogIn;
    private Long roleId;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public UserPO() {

    }

    public UserPO(Long id, String name, String email, String avatar, String account, String password, Boolean isLogIn, Long roleId, Timestamp createTime, Timestamp modifyTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.account = account;
        this.password = password;
        this.isLogIn = isLogIn;
        this.roleId = roleId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }
}

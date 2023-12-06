package com.wide.cakeapplication.infrastructure.mysql.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@Table(name = "employee")
@ToString
@Entity
public class EmployeePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String avatar;
    private String account;
    private String password;
    private Boolean isLogIn;
    private Long department;
    private String address;
    private Long roleId;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public EmployeePO(Long id, String name, String email, String avatar, String account, String password, Boolean isLogIn, Long department, String address, Long roleId, Timestamp createTime, Timestamp modifyTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.account = account;
        this.password = password;
        this.isLogIn = isLogIn;
        this.department = department;
        this.address = address;
        this.roleId = roleId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public EmployeePO() {

    }
}

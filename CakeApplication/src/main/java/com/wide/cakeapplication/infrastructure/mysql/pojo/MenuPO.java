package com.wide.cakeapplication.infrastructure.mysql.pojo;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "menu")
@ToString
@Builder
public class MenuPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //the level of menu , begin with 0, and level 1 is the sub menu of level 0
    @Column(nullable = false,columnDefinition = "int DEFAULT 0")
    private Integer level;
    // parent menu id
    private Long parentMenu;
    //the scope of menu (0:user;1:employee;2:special user)
    @Column(nullable = false,columnDefinition = "int DEFAULT 0")
    private String scope;
    // menu name
    @Column(nullable = true,columnDefinition = "varchar(50)")
    private String name;
    // the uri or url of this menu
    @Column(nullable = false,columnDefinition = "varchar(100)")
    private String url;
    // the create user account
    private String createUser;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public MenuPO() {

    }

    public MenuPO(Long id, Integer level, Long parentMenu, String scope, String name, String url, String createUser, Timestamp createTime, Timestamp modifyTime) {
        this.id = id;
        this.level = level;
        this.parentMenu = parentMenu;
        this.scope = scope;
        this.name = name;
        this.url = url;
        this.createUser = createUser;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }
}

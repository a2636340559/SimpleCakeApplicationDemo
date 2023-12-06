package com.wide.cakeapplication.infrastructure.mysql.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@Table(name = "role")
@ToString
@Entity
public class RolePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // the name of user role
    @Column(nullable = false)
    private String name;

    public RolePO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RolePO() {

    }
}

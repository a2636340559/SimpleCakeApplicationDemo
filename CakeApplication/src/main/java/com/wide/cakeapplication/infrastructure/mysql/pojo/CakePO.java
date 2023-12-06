package com.wide.cakeapplication.infrastructure.mysql.pojo;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Table(name = "cake")
@ToString
@Entity
@Builder
public class CakePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String images;
    private BigDecimal price;
    //the scope of menu (0:user;1:employee;2:special user)
    private String scope;
    private String ingredient;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createTime;
    private Timestamp modifyTime;

    public CakePO() {
    }

    public CakePO(Long id,String name, String images, BigDecimal price, String scope, String ingredient, Timestamp createTime, Timestamp modifyTime) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.price = price;
        this.scope = scope;
        this.ingredient = ingredient;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }
}

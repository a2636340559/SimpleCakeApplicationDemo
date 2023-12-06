package com.wide.cakeapplication.intefaces.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class CakeDTO {
    private String cakeId;
    private String cakeName;
    private List<String> cakeImages;
    @JsonIgnore
    private String cakeImagesStr;
    private BigDecimal price;
    //the scope of menu (0:user;1:employee;2:special user)
    private String ingredient;
    @JsonIgnore
    private UserDTO user;
}

package com.wide.cakeapplication.intefaces.assembler;

import com.wide.cakeapplication.infrastructure.mysql.pojo.CakePO;
import com.wide.cakeapplication.infrastructure.mysql.pojo.MenuPO;
import com.wide.cakeapplication.intefaces.dto.CakeDTO;
import com.wide.cakeapplication.intefaces.dto.MenuDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CakeTransfer {

    public static CakeDTO toCakeDTO(CakePO cakePO){
        return CakeDTO.builder()
                .cakeId(String.valueOf(cakePO.getId()))
                .cakeName(cakePO.getName())
                .price(cakePO.getPrice())
                .ingredient(cakePO.getIngredient())
                .cakeImages(Arrays.asList(cakePO.getImages().split(";")))
                .build();
    }
    public static List<CakeDTO> toCakeDTOList(List<CakePO> cakePOList){
        List<CakeDTO> cakeDTOList = new ArrayList<>();
        cakePOList.forEach(bean->{cakeDTOList.add(toCakeDTO(bean));});
        return cakeDTOList;
    }

    public static CakePO toCakePO(CakeDTO cakeDTO){
        return CakePO.builder()
                .name(cakeDTO.getCakeName())
                .scope(cakeDTO.getUser().getUserIdentity())
                .images(cakeDTO.getCakeImagesStr())
                .ingredient(cakeDTO.getIngredient())
                .price(cakeDTO.getPrice())
                .build();
    }
}

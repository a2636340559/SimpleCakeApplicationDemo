package com.wide.cakeapplication.intefaces.assembler;

import com.wide.cakeapplication.infrastructure.mysql.pojo.MenuPO;
import com.wide.cakeapplication.intefaces.dto.MenuDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MenuTransfer {

    public static MenuDTO toMenuDTO(MenuPO menuPO){
        return MenuDTO.builder().menuLevel(menuPO.getLevel()).menuName(menuPO.getName())
                .url(menuPO.getUrl()).parentMenu(menuPO.getParentMenu()).build();
    }

    public static MenuPO toMenuPO(MenuDTO menuDTO){
        return MenuPO.builder()
                .level(menuDTO.getMenuLevel())
                .createUser(menuDTO.getCreateUser())
                .name(menuDTO.getMenuName())
                .scope(menuDTO.getScope())
                .url(menuDTO.getUrl())
                .parentMenu(menuDTO.getParentMenu())
                .modifyTime(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }
    public static List<MenuPO> toMenuPOList(List<MenuDTO> list){
        List<MenuPO> menuPOList = new ArrayList<>();
        list.forEach(bean->{menuPOList.add(toMenuPO(bean));});
        return menuPOList;
    }

    public static List<MenuDTO> toMenuDTOList(List<MenuPO> list){
        List<MenuDTO> menuDTOList = new ArrayList<>();
        list.forEach(bean->{menuDTOList.add(toMenuDTO(bean));});
        return menuDTOList;
    }
}

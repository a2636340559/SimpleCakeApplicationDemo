package com.wide.cakeapplication.domain.menu;

import com.wide.cakeapplication.infrastructure.enums.IdentityEnum;
import com.wide.cakeapplication.infrastructure.mysql.pojo.MenuPO;
import com.wide.cakeapplication.infrastructure.mysql.pojo.UserPO;
import com.wide.cakeapplication.infrastructure.mysql.repository.menu.MenuRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class MenuDomain {
    @Resource
    MenuRepository menuRepository;

    public List<MenuPO> getMenuList(UserPO queryUser) throws Exception{
        if (Long.valueOf(IdentityEnum.USER.getIdentityCode()).equals(queryUser.getRoleId())) {
            log.info("query the menu opened to user");
        }
        if (Long.valueOf(IdentityEnum.EMPLOYEE.getIdentityCode()).equals(queryUser.getRoleId())) {
            log.info("query the menu opened to employee");
        }
        List<MenuPO> menuList = new ArrayList<>();
        menuList = menuRepository.getMenuPOSByScope(String.valueOf(queryUser.getRoleId()));

        return menuList;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<MenuPO> addMenu(List<MenuPO> menuList) throws Exception{
        try {
            menuList = menuRepository.saveAll(menuList);
        }catch (Exception e){
            log.error("batch add menu failed,exception is:{}",e.getMessage(),e);
        }
        return menuList;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteMenu(Integer menuId) throws Exception{
        try {
            menuRepository.deleteById(Long.valueOf(menuId));
        }catch (Exception e){
            log.error("delete menu failed:{}",e.getMessage(),e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(MenuPO menuPO) throws Exception{
            menuRepository.save(menuPO);
    }


}

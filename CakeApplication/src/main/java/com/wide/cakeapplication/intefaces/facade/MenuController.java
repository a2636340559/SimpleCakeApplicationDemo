package com.wide.cakeapplication.intefaces.facade;

import com.wide.cakeapplication.domain.menu.MenuDomain;
import com.wide.cakeapplication.infrastructure.common.Response;
import com.wide.cakeapplication.infrastructure.mysql.pojo.MenuPO;
import com.wide.cakeapplication.infrastructure.mysql.pojo.UserPO;
import com.wide.cakeapplication.intefaces.assembler.MenuTransfer;
import com.wide.cakeapplication.intefaces.assembler.UserTransfer;
import com.wide.cakeapplication.intefaces.dto.MenuDTO;
import com.wide.cakeapplication.intefaces.dto.UserDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class MenuController {


    @Resource
    MenuDomain menuDomain;

    @RequestMapping(value = "/menu/v1/list",method = RequestMethod.POST)
    @ResponseBody
    public Response getMenu(@RequestBody @Validated UserDTO userDTO) {
        UserPO queryUser = UserTransfer.toUserPO(userDTO);
        List<MenuPO> menuList = new ArrayList<>();
        try {
            menuList = menuDomain.getMenuList(queryUser);
        } catch (Exception e) {
            log.error("there have something wrong when query menu,exception is :{}", e.getMessage(), e);
            return Response.FAILED(e);
        }
        if (CollectionUtils.isEmpty(menuList)) {
            return Response.SUCCESS("dont have any menu");
        }
        return Response.SUCCESS(MenuTransfer.toMenuDTOList(menuList));
    }

    @RequestMapping("/menu/v1/add")
    public Response addMenu(@RequestBody List<MenuDTO> menus) {
        Object result = null;
        try {
             result = menuDomain.addMenu(MenuTransfer.toMenuPOList(menus));
        } catch (Exception e) {
            log.error("add menu failed, exception is:{}",e.getMessage(),e);
            return Response.FAILED(e);
        }
        return Response.SUCCESS(result);
    }

    @RequestMapping("/menu/v1/delete")
    public Response deleteMenu(Integer menuId) {
        try {
            menuDomain.deleteMenu(menuId);
        } catch (Exception e) {
            log.error("add menu failed, exception is:{}",e.getMessage(),e);
            return Response.FAILED(e);
        }
        return Response.SUCCESS();
    }

    @RequestMapping("/menu/v1/update")
    public Response updateMenu(@RequestBody MenuDTO menuDTO) {
        try {
            MenuPO menuPO = MenuTransfer.toMenuPO(menuDTO);
            menuDomain.updateMenu(menuPO);
        } catch (Exception e) {
            log.error("add menu failed, exception is:{}",e.getMessage(),e);
            return Response.FAILED(e);
        }
        return Response.SUCCESS();
    }


}

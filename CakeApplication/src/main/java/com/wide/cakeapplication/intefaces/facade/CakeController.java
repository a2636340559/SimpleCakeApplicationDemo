package com.wide.cakeapplication.intefaces.facade;

import com.wide.cakeapplication.application.cake.CakeService;
import com.wide.cakeapplication.infrastructure.common.Response;
import com.wide.cakeapplication.infrastructure.mysql.pojo.CakePO;
import com.wide.cakeapplication.intefaces.assembler.CakeTransfer;
import com.wide.cakeapplication.intefaces.dto.CakeDTO;
import com.wide.cakeapplication.intefaces.dto.UserDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class CakeController {
    @Resource
    CakeService cakeService;

    @RequestMapping(value = "/cake/v1/list",method = RequestMethod.POST)
    public Response queryCakeList(@RequestBody UserDTO queryUser){
        List<CakePO> cakePOList = new ArrayList<>();
        try {
            cakePOList = cakeService.queryCakeList(queryUser);
        } catch (Exception e) {
            log.error("query cake list error,exception:{}",e.getMessage(),e);
            return Response.FAILED(e);
        }
        return Response.SUCCESS(CakeTransfer.toCakeDTOList(cakePOList));
    }

    @RequestMapping(value = "/cake/v1/add",method = RequestMethod.POST)
    public Response addCake(@RequestBody CakeDTO cake){
       CakePO cakePO = CakeTransfer.toCakePO(cake);
        try {
            cakePO.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            cakePO = cakeService.addCake(cakePO);
        } catch (Exception e) {
            log.error("add cake failed,exception:{}",e.getMessage(),e);
            return Response.FAILED(e);
        }
        return Response.SUCCESS(cakePO.getId());
    }

}

package com.wide.cakeapplication.application.cake;

import com.wide.cakeapplication.domain.cake.CakeDomain;
import com.wide.cakeapplication.infrastructure.enums.IdentityEnum;
import com.wide.cakeapplication.infrastructure.mysql.pojo.CakePO;
import com.wide.cakeapplication.intefaces.dto.UserDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CakeService {
    @Resource
    CakeDomain cakeDomain;
    public List<CakePO> queryCakeList(UserDTO queryUser) throws Exception{
        List<CakePO> cakePOS = new ArrayList<>();
        if (IdentityEnum.USER.getIdentityCode().equals(queryUser.getUserIdentity())) {
            cakePOS = cakeDomain.findCakeByScope(queryUser.getUserIdentity());
        }
        if (IdentityEnum.EMPLOYEE.getIdentityCode().equals(queryUser.getUserIdentity())) {
            cakePOS = cakeDomain.findAllCake();
        }
        return cakePOS;
    }

    public CakePO addCake(CakePO cakePO) throws Exception{
        return cakeDomain.addCake(cakePO);
    }
}

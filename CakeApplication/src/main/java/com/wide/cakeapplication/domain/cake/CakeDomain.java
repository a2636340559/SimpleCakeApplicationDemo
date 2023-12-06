package com.wide.cakeapplication.domain.cake;

import com.wide.cakeapplication.infrastructure.mysql.pojo.CakePO;
import com.wide.cakeapplication.infrastructure.mysql.repository.cake.CakeRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CakeDomain {
    @Resource
    CakeRepository cakeRepository;

    public List<CakePO> findAllCake(){
        return cakeRepository.findAll();
    }
    public List<CakePO> findCakeByScope(String scope){
        return cakeRepository.queryCakePOSByScope(scope);
    }

    public CakePO addCake(CakePO cake){
        return cakeRepository.save(cake);
    }
}

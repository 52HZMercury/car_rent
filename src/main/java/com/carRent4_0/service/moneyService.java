package com.carRent4_0.service;

import com.carRent4_0.mapper.moneyMapper;
import com.carRent4_0.pojo.money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-11-02 19:58
 **/
@Service
public class moneyService {

    @Autowired
    private moneyMapper moneyMapper;


    public  money getmoney(){
       return  moneyMapper.getmoney();
    }

    public void updatemoney(double money){
        moneyMapper.updatemoney(money);
     }
}

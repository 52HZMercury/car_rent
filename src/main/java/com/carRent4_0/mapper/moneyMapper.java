package com.carRent4_0.mapper;

import com.carRent4_0.pojo.money;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface moneyMapper {
      money getmoney();
      void updatemoney(double money);
}

package com.carRent4_0.mapper;

import com.carRent4_0.pojo.Bus;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BusMapper {

    List<Bus> queryBusList();

    Bus loadBusByVehicled(String Vehicled);

    int addBus(Bus bus);

    int upDateBus(Bus bus);

    int deleteBus(String  Vehicled);
}

package com.carRent4_0.mapper;

import com.carRent4_0.pojo.Truck;
import com.carRent4_0.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TruckMapper {

    List<Truck> queryTruckList();

    Truck loadTruckByVehicled(String Vehicled);

    int addTruck(Truck truck);

    int upDateTruck(Truck truck);

    int deleteTruck(String Vehicled);
}

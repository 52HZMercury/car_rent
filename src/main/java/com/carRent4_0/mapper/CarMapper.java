package com.carRent4_0.mapper;

import com.carRent4_0.pojo.Car;
import com.carRent4_0.pojo.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CarMapper {

    List<Car> queryCarList();

    Car loadCarByVehicled(String Vehicled);

    int addCar(Car car);

    int upDateCar(Car car);

    int deleteCar(String Vehicled);


}

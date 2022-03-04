package com.carRent4_0.service;

import com.carRent4_0.mapper.BusMapper;
import com.carRent4_0.mapper.CarMapper;
import com.carRent4_0.mapper.TruckMapper;
import com.carRent4_0.pojo.Bus;
import com.carRent4_0.pojo.Car;
import com.carRent4_0.pojo.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-10-28 20:01
 **/

@Service
public class VehicleService {

    @Autowired
    private BusMapper busMapper;


    @Autowired
    private CarMapper carMapper;


    @Autowired
    private TruckMapper truckMapper;

    /**
     * @Description: 以集合的方式返回所有的bus
     * @Param:
     * @return: list<Bus>
     */

    public List<Bus> getAllBus() {
        return busMapper.queryBusList();
    }


    /**
     * @Description: 以集合的方式返回所有的car
     * @Param:
     * @return: list<car>
     */

    public List<Car> getAllCar() {
        return carMapper.queryCarList();
    }

    /**
     * @Description: 以集合的方式返回所有的truck
     * @Param:
     * @return: list<Truck>
     */

    public List<Truck> getAllTruck() {
        return truckMapper.queryTruckList();
    }


    public double countRentMoeny(String Vehicled, int day){
         Car car = carMapper.loadCarByVehicled(Vehicled);
         Bus bus = busMapper.loadBusByVehicled(Vehicled);
        Truck truck = truckMapper.loadTruckByVehicled(Vehicled);
        if(car!=null){
            return car.calRent(day);
        }else if(bus!=null){
            return bus.calRent(day);
        }else if(truck!=null){
            return truck.calRent(day);
        }
        return 0;
    }

    public void deleteCar(String Vehicled){
        carMapper.deleteCar(Vehicled);
    }

    public void deleteBus(String Vehicled){
        busMapper.deleteBus(Vehicled);
    }

    public void deleteTruck(String Vehicled){
        truckMapper.deleteTruck(Vehicled);
    }

    public void addCar(Car addCar){
        carMapper.addCar(addCar);
    }

    public void addBus(Bus addBus){
        busMapper.addBus(addBus);
    }

    public void addTruck(Truck addTruck){
        truckMapper.addTruck(addTruck);
    }

    public void updateCar(Car updateCar){
        carMapper.upDateCar(updateCar);
    }

    public void updateBus(Bus updateBus){
        busMapper.upDateBus(updateBus);
    }

    public void updateTruck(Truck updateTruck){
        truckMapper.upDateTruck(updateTruck);
    }

    public Car getCar(String Vehicled){
        return carMapper.loadCarByVehicled(Vehicled);
    }

    public Bus getBus(String Vehicled){
        return busMapper.loadBusByVehicled(Vehicled);
    }

    public Truck getTruck(String Vehicled){
        return truckMapper.loadTruckByVehicled(Vehicled);
    }

}

package com.carRent4_0.controller;

import com.carRent4_0.pojo.Bus;
import com.carRent4_0.pojo.Car;
import com.carRent4_0.pojo.Truck;
import com.carRent4_0.pojo.money;
import com.carRent4_0.service.VehicleService;
import com.carRent4_0.service.moneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-10-30 14:40
 **/
@Controller
public class VehicleController {

     @Autowired
     private VehicleService vehicleService;

     @Autowired
     private moneyService moneyService;
    /**
     * @Description:
     * @Param:
     * @return:
     */
    @RequestMapping("/user/rentVehicle.html")
     public String  getAllVehicle(Model model){
         model.addAttribute("Allbus",vehicleService.getAllBus());
         model.addAttribute("Allcar",vehicleService.getAllCar());
         model.addAttribute("Alltruck",vehicleService.getAllTruck());
         return "rentVehicle";
    }

    @RequestMapping("/user/success.html")
    public String countrentmoney( String Vehicledbus,String Vehicledcar,String Vehicledtruck ,int daybus,int daycar,int daytruck,Model model,HttpSession session){

        double moneybus = 0;
        double moneycar = 0;
        double moneytruck = 0;
        moneybus = vehicleService.countRentMoeny(Vehicledbus,daybus);
        moneycar = vehicleService.countRentMoeny(Vehicledcar,daycar);
        moneytruck = vehicleService.countRentMoeny(Vehicledtruck,daytruck);
        if(moneybus != 0){
            vehicleService.deleteBus(Vehicledbus);
        }
        if(moneycar != 0){
            vehicleService.deleteCar(Vehicledcar);
        }
        if(moneytruck !=0){
            vehicleService.deleteTruck(Vehicledtruck);
        }


        double totalmoney = moneybus+moneycar+moneytruck;

        double totalsalemoney = totalmoney+moneyService.getmoney().getMoney();
        moneyService.updatemoney(totalsalemoney);

        model.addAttribute("TotalMoney",totalmoney);
        return "success";
    }

    @RequestMapping("/admin/dashboard.html")
    public String  getAllrentVehicle(Model model){
        model.addAttribute("Allbus",vehicleService.getAllBus());
        model.addAttribute("Allcar",vehicleService.getAllCar());
        model.addAttribute("Alltruck",vehicleService.getAllTruck());
        return "dashboard";
    }

    /**
     * @Description: busupdate
     * @Param:
     * @return:
     */


    @RequestMapping("/admin/busUpdate/{Vehicled}")
    public String updatebus(@PathVariable("Vehicled") String Vehicled, Model model, HttpSession session){
        Bus updatebus =  vehicleService.getBus(Vehicled);
        model.addAttribute("updatebus",updatebus);
        session.setAttribute("updatebusVehicled",updatebus.getVehicled());
        return "busUpdate";
    }

    @RequestMapping("/admin/busUpdate")
    public String updatebus(String brand ,int perRent ,int seat,HttpSession session){

        Bus updatebus = new Bus((String) session.getAttribute("updatebusVehicled"),brand,perRent,seat);
        vehicleService.updateBus(updatebus);
        return "redirect:/admin/dashboard.html";
    }



    @RequestMapping("/admin/busdelete/{Vehicled}")
    public String deletebus(@PathVariable("Vehicled") String Vehicled){
        vehicleService.deleteBus(Vehicled);
        return "redirect:/admin/dashboard.html";
    }

    /**
     * @Description:updatecar
     * @Param:
     * @return:
     */


    @RequestMapping("/admin/carUpdate/{Vehicled}")
    public String updatecar(@PathVariable("Vehicled") String Vehicled, Model model, HttpSession session){
        Car updatecar =  vehicleService.getCar(Vehicled);
        model.addAttribute("updatecar",updatecar);
        session.setAttribute("updatebusVehicled",updatecar.getVehicled());
        return "carUpdate";
    }

    @RequestMapping("/admin/carUpdate")
    public String updatecar(String brand ,int perRent ,String Type,HttpSession session){

        Car updatecar = new Car((String) session.getAttribute("updatebusVehicled"),brand,perRent,Type);
        vehicleService.updateCar(updatecar);
        return "redirect:/admin/dashboard.html";
    }


    @RequestMapping("/admin/cardelete/{Vehicled}")
    public String deletecar(@PathVariable("Vehicled") String Vehicled){
        vehicleService.deleteCar(Vehicled);
        return "redirect:/admin/dashboard.html";
    }



    /**
     * @Description: truckupdate
     * @Param:
     * @return:
     */

    @RequestMapping("/admin/truckUpdate/{Vehicled}")
    public String updatetruck(@PathVariable("Vehicled") String Vehicled, Model model, HttpSession session){
        Truck updatetruck =  vehicleService.getTruck(Vehicled);
        model.addAttribute("updatetruck",updatetruck);
        session.setAttribute("updatebusVehicled",updatetruck.getVehicled());
        return "truckUpdate";
    }

    @RequestMapping("/admin/truckUpdate")
    public String updatetruck(String brand ,Integer perRent ,Integer loadage,HttpSession session){

        Truck updatetruck = new Truck((String) session.getAttribute("updatebusVehicled"),brand,perRent,loadage);
        vehicleService.updateTruck(updatetruck);
        return "redirect:/admin/dashboard.html";
    }

    @RequestMapping("/admin/truckdelete/{Vehicled}")
    public String deletetruck(@PathVariable("Vehicled") String Vehicled){
        vehicleService.deleteTruck(Vehicled);
        return "redirect:/admin/dashboard.html";
    }

    @RequestMapping("/admin/carAdd" )
    public String Addcar(String Vehicled,String brand ,Integer perRent ,String Type){
        Car addcar = new Car(Vehicled,brand,perRent,Type);
        vehicleService.addCar(addcar);
        return "redirect:/admin/dashboard.html";
    }

    @RequestMapping("/admin/busAdd")
    public String Addbus(String Vehicled,String brand ,Integer perRent ,Integer seat){
        Bus addbus = new Bus(Vehicled,brand,perRent,seat);
        vehicleService.addBus(addbus);
        return "redirect:/admin/dashboard.html";
    }

    @RequestMapping("/admin/truckAdd")
    public String Addtruck(String Vehicled,String brand ,Integer perRent ,Integer loadage){
        Truck addtruck = new Truck(Vehicled,brand,perRent,loadage);
        vehicleService.addTruck(addtruck);
        return "redirect:/admin/dashboard.html";
    }



}

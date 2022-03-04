package com.carRent4_0.pojo;


/**
 * @program: carRent2
 * @description:
 * @author: Mr.Like
 * @create: 2021-09-26 16:28
 **/
public class Car extends Vehicle {


    private String Type;//独有的type属性


    public Car() {
    }

    public Car(String vehicled, String brand, int perRent, String Type) {
        super(vehicled, brand, perRent);
        this.Type = Type;
    }

    public String getType() {
        return Type;
    }

    public void setType( String type) {
        Type = type;
    }



}

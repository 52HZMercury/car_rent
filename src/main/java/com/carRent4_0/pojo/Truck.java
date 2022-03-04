package com.carRent4_0.pojo;




public class Truck extends Vehicle {
    private  int loadage;

    public Truck() {
    }

    public Truck(String vehicled, String brand, int perRent, int loadage) {
        super(vehicled, brand, perRent);
        this.loadage = loadage;
    }

    public int getLoadage() {
        return loadage;
    }

    public void setLoadage(int loadage) {
        this.loadage = loadage;
    }




}

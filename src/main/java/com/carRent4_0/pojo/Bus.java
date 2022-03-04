package com.carRent4_0.pojo;




public class Bus extends Vehicle {
    private int seat;


    public Bus() {
    }

    public Bus(String vehicled, String brand, int perRent, int seat) {
        super(vehicled, brand, perRent);
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }




}

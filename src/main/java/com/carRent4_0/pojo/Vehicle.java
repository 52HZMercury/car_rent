package com.carRent4_0.pojo;


public  abstract  class Vehicle {
     //使用抽象父类定义方法属性，由子类继承后重写租车和计算租金的方法
     private String Vehicled;//车牌号
     private String  brand;//品牌
     private int perRent;//日租金
     //三种车都含有这三种特性，根据独有的具体型号的不同，用以区别他们不同的租金


    public Vehicle() {
    }

    public Vehicle(String vehicled, String brand, int perRent) {
        Vehicled = vehicled;
        this.brand = brand;
        this.perRent = perRent;
    }

    public String getVehicled() {
        return Vehicled;
    }

    public void setVehicled(String vehicled) {
        Vehicled = vehicled;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPerRent() {
        return perRent;
    }

    public void setPerRent(int perRent) {
        this.perRent = perRent;
    }

    public  double calRent(int day){
        if(day<0){
            System.out.println("天数不能小于0天哦");
        }else if(day > 0 && day < 7){
            return  (double)this.getPerRent()*day;
        }else if(day >= 7 && day < 30){
            return  (double)this.getPerRent()*day*0.9;
        }else if(day >= 30 && day < 150){
            return  (double)this.getPerRent()*day*0.8;
        }else if(day > 150 ){
            return  (double)this.getPerRent()*day*0.7;
        }
       return 0;
    }//计算租金的方法



}

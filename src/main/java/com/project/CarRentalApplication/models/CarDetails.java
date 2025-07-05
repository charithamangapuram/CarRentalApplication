package com.project.CarRentalApplication.models;

public class CarDetails {
    private String car_id;
    private String car_name;
    private String car_num;
    private String reg_num;
    private String storage_capacity;
    private String categoty_id;
    private String subcategory_id;
    private String price_perday;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public String getPrice_perday() {
        return price_perday;
    }

    public void setPrice_perday(String price_perday) {
        this.price_perday = price_perday;
    }

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(String subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public String getCategoty_id() {
        return categoty_id;
    }

    public void setCategoty_id(String categoty_id) {
        this.categoty_id = categoty_id;
    }

    public String getStorage_capacity() {
        return storage_capacity;
    }

    public void setStorage_capacity(String storage_capacity) {
        this.storage_capacity = storage_capacity;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }
}

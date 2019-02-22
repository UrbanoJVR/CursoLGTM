package com.autentia.cursolgtm.insecureDeserialization;

import java.io.Serializable;

public class Car implements Serializable {

    private String plateNumber;
    private String model;
    private String ownerName;
    private int year;

    Car(String plateNumber, String model, String ownerName, int year) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.ownerName = ownerName;
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", model='" + model + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", year=" + year +
                '}';
    }
}

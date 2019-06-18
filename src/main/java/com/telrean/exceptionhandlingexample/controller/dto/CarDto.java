package com.telrean.exceptionhandlingexample.controller.dto;

public class CarDto {
    public String serialNumber;
    public String model;
    public int year;

    @Override
    public String toString() {
        return "CarDto{" +
                "serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}

package com.telrean.exceptionhandlingexample.controller;

import com.telrean.exceptionhandlingexample.controller.dto.CarDto;
import com.telrean.exceptionhandlingexample.exception.WrongCarFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class CarController {
    ConcurrentHashMap<String, CarDto> cars = new ConcurrentHashMap<>();

    @PostMapping("car")
    public void addCar(@RequestBody CarDto car){
        validator(car);
        cars.putIfAbsent(car.serialNumber,car);
    }


    @GetMapping("car/{serialNumber}")
    public CarDto getCarById(@PathVariable("serialNumber")String serialNumber){
        CarDto res = cars.get(serialNumber);
        if(res == null){
//            throw new CarNotFoundException("Car with serialNumber: "+serialNumber+" does not exist!");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Wrong authorization!");
        }
        return res;
    }
    private void validator(CarDto car){
        if (car.model == null || car.model.isEmpty()){
            throw new WrongCarFormatException("model can't be empty");
        }
        if(car.serialNumber == null || car.serialNumber.isEmpty()){
            throw new WrongCarFormatException("serial number can't be empty");
        }

        if(car.year < 2010){
            throw new WrongCarFormatException("Wrong year format! Year should be bigger 2010");
        }

        if(car.year > 2015){
            throw new IllegalArgumentException("Wrong year!");
        }
    }
}

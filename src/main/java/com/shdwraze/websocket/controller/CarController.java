package com.shdwraze.websocket.controller;

import com.shdwraze.websocket.model.entity.Car;
import com.shdwraze.websocket.model.request.CarRequest;
import com.shdwraze.websocket.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/cars")
    public Car createCar(@RequestBody CarRequest carRequest) {
        return carService.createCar(carRequest.brand(), carRequest.model());
    }
}

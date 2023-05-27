package com.shdwraze.websocket.service;

import com.shdwraze.websocket.model.entity.Car;
import com.shdwraze.websocket.repo.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final SimpMessagingTemplate messagingTemplate;

    public Car createCar(String brand, String model) {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);

        car = carRepository.save(car);

        // Отправляем уведомление о новом автомобиле
        messagingTemplate.convertAndSend("/topic/cars", car);

        return car;
    }
}

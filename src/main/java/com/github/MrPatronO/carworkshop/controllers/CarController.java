package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.models.Car;
import com.github.MrPatronO.carworkshop.services.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
class CarController {

    @Autowired
    private final CarService carService;

    public static final Logger logger = LoggerFactory.getLogger(CarController.class);

    CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    ResponseEntity<Car> readCars(@PathVariable int carId) {

        return carService.findAll();
    }

    @PostMapping
    Car newCar(@RequestBody @Validated Car newCar) {

        return  carService.save(newCar);
    }

    @GetMapping("/{id}")
    Car readIdCars(@PathVariable int carId) {

        return carService.findById(carId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    Car updateCar(@PathVariable int carId, @RequestBody @Validated Car newCar) {
        return carService.findById(carId)
                .map(car -> {
                    car.setBrand(newCar.getBrand());
                    car.setEngine(newCar.getEngine());
                    car.setModel(newCar.getModel());
                    car.setVintage(newCar.getVintage());
                    car.setTypeFuel(newCar.getTypeFuel());
                    return carService.save(car);
                })
                .orElseGet(() -> {
                    newCar.setCarId(carId);
                    return carService.save(newCar);
                })  ;

    }

    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable int carId) {
        carService.deleteById(carId);
    }

}

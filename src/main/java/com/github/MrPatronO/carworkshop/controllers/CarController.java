package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.dtos.CarDto;
import com.github.MrPatronO.carworkshop.dtos.NewCarDto;
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
    ResponseEntity<Car> readCars(Integer carId) {

        return carService.findAll();
    }

    @PostMapping
    CarDto newCar(@RequestBody @Validated NewCarDto newCarDto) {

        return  carService.save(newCarDto);
    }

    @GetMapping("/{id}")
    Car readIdCars(Integer carId) {

        return carService.findById(carId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    ResponseEntity<CarDto> updateCar(@PathVariable Integer id,@RequestBody @Validated CarDto carDto) {
        return ResponseEntity.ok(carService.update(carDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteCar(Integer id) {
        carService.deleteById(id);
    }

}

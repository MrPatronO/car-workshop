package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.dtos.CarDto;
import com.github.MrPatronO.carworkshop.dtos.NewCarDto;
import com.github.MrPatronO.carworkshop.models.Car;
import com.github.MrPatronO.carworkshop.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
class CarController {

    @Autowired
    private final CarService carService;

    CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    List<Car> readCars(Long carId) {

        return carService.findAll();
    }

    @PostMapping
    ResponseEntity<CarDto> newCar(@RequestBody @Validated NewCarDto newCarDto) {

        return  ResponseEntity.ok(carService.save(newCarDto)) ;
    }

    @GetMapping("/{id}")
    @ResponseBody
    Optional<Car> readCarById(@PathVariable("id")  Long id) {

        return carService.findById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<CarDto> updateCar(@PathVariable("id") Long id,@RequestBody @Validated CarDto carDto) {
        return ResponseEntity.ok(carService.update(carDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable("id")  Long id) {
        carService.deleteById(id);
    }

}

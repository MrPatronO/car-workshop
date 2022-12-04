package com.github.MrPatronO.carworkshop.controller;

import com.github.MrPatronO.carworkshop.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cars")
class CarController {

    @Autowired
    private final CarService carService;

    CarController(CarService carService) {
        this.carService = carService;
    }

}

package com.github.MrPatronO.carworkshop.services.interfaces;


import com.github.MrPatronO.carworkshop.models.Car;
import org.springframework.http.ResponseEntity;

public interface CarInterface {

    public abstract Car save(Car car);

    ResponseEntity<Car> findAll();

    void deleteById(int carId);
}

package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.models.Car;
import com.github.MrPatronO.carworkshop.repositories.CarRepository;
import com.github.MrPatronO.carworkshop.services.interfaces.CarInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService implements CarInterface {

    final CarRepository carRepository;

    CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public ResponseEntity<Car> findAll() {
        return null;
    }

    @Override
    public void deleteById(int carId) {

    }

    public Optional<Car> findById(Integer integer) {
        return carRepository.findById(integer);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

    public boolean existsByCarId(Integer integer) {
        return carRepository.existsById(integer);
    }


}

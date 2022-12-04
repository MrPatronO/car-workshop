package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.model.Car;
import com.github.MrPatronO.carworkshop.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    final CarRepository carRepository;

    CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll(Car car) {
        return carRepository.findAll(car);
    }

    public Car save(Car car) {
        return carRepository.save(car);
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

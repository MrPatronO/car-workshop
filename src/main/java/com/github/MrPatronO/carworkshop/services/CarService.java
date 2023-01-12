package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.CarDto;
import com.github.MrPatronO.carworkshop.dtos.NewCarDto;
import com.github.MrPatronO.carworkshop.models.Car;
import com.github.MrPatronO.carworkshop.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDto save(NewCarDto newCarDto) {

        Car car = new Car();
            car.setVintage(newCarDto.getVintage());
            car.setTypeFuel(newCarDto.getTypeFuel());
            car.setModel(newCarDto.getModel());
            car.setEngine(newCarDto.getEngine());
            car.setBrand(newCarDto.getBrand());

        Car newCar = carRepository.save(car);

        CarDto carDto = new CarDto();
        carDto.setCarId(newCar.getCarId());
        carDto.setVintage(newCar.getVintage());
        carDto.setTypeFuel(newCar.getTypeFuel());
        carDto.setModel(newCar.getModel());
        carDto.setEngine(newCar.getEngine());
        carDto.setBrand(newCar.getBrand());

        return carDto;
    }


    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(Long id) {

        return carRepository.findById(id);
    }


    public CarDto update(CarDto carDto, Long carId) {
        Car updatedOrCreatedCar = carRepository.findById(carId)
                .map(car -> {
                    car.setBrand(carDto.getBrand());
                    car.setEngine(carDto.getEngine());
                    car.setModel(carDto.getModel());
                    car.setVintage(carDto.getVintage());
                    car.setTypeFuel(carDto.getTypeFuel());
                    return carRepository.save(car);
                })
                .orElseGet(() -> {
                    Car car = new Car();
                    car.setCarId(carDto.getCarId());
                    car.setVintage(carDto.getVintage());
                    car.setTypeFuel(carDto.getTypeFuel());
                    car.setModel(carDto.getModel());
                    car.setEngine(carDto.getEngine());
                    car.setBrand(carDto.getBrand());

                    return carRepository.save(car);
                })  ;
        CarDto newCarDto = new CarDto();
        newCarDto.setCarId(updatedOrCreatedCar.getCarId());
        newCarDto.setVintage(updatedOrCreatedCar.getVintage());
        newCarDto.setTypeFuel(updatedOrCreatedCar.getTypeFuel());
        newCarDto.setModel(updatedOrCreatedCar.getModel());
        newCarDto.setEngine(updatedOrCreatedCar.getEngine());
        newCarDto.setBrand(updatedOrCreatedCar.getBrand());

        return newCarDto;
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}

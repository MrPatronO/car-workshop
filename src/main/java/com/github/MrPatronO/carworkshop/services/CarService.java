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

        return mapToCarDto(newCar);
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
                    mapToCar(car,carDto);
                    return carRepository.save(car);
                })
                .orElseGet(() -> {
                    Car car = new Car();
                    car.setCarId(carDto.getCarId());

                    mapToCar(car,carDto);

                    return carRepository.save(car);
                })  ;

        Car newCar = carRepository.save(updatedOrCreatedCar);

        return mapToCarDto(newCar);
    }

    public void deleteById(Long id) {

        carRepository.deleteById(id);
    }


    private CarDto mapToCarDto(Car car){

        CarDto carDto = new CarDto();
        carDto.setCarId(car.getCarId());
        carDto.setVintage(car.getVintage());
        carDto.setTypeFuel(car.getTypeFuel());
        carDto.setModel(car.getModel());
        carDto.setEngine(car.getEngine());
        carDto.setBrand(car.getBrand());

        return carDto;
    }

    private void mapToCar(Car car, CarDto carDto){
        car.setBrand(carDto.getBrand());
        car.setEngine(carDto.getEngine());
        car.setModel(carDto.getModel());
        car.setVintage(carDto.getVintage());
        car.setTypeFuel(carDto.getTypeFuel());
    }

}

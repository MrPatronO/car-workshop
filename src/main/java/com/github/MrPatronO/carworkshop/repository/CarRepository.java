package com.github.MrPatronO.carworkshop.repository;

import com.github.MrPatronO.carworkshop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAll(Car car);

    boolean existsByCarId(int carId);
}

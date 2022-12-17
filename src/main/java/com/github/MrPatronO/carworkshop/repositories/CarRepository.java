package com.github.MrPatronO.carworkshop.repositories;

import com.github.MrPatronO.carworkshop.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}

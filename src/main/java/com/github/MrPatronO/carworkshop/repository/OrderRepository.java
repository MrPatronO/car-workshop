package com.github.MrPatronO.carworkshop.repository;

import com.github.MrPatronO.carworkshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}

package com.github.MrPatronO.carworkshop.services.interfaces;

import com.github.MrPatronO.carworkshop.models.Order;
import org.springframework.http.ResponseEntity;

public interface OrderInterface {

    public abstract Order save(Order order);

    ResponseEntity<Order> findAll();

    void deleteById(int orderId);
}

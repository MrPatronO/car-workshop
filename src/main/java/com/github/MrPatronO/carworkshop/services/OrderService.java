package com.github.MrPatronO.carworkshop.services;


import com.github.MrPatronO.carworkshop.models.Order;
import com.github.MrPatronO.carworkshop.repositories.OrderRepository;
import com.github.MrPatronO.carworkshop.services.interfaces.OrderInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements OrderInterface {

    final OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public ResponseEntity<Order> findAll() {
        return null;
    }

    @Override
    public void deleteById(int orderId) {

    }

    public Optional<Order> findById(Integer integer) {
        return orderRepository.findById(integer);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }

    public boolean existsByOrderId(Integer integer) {
        return orderRepository.existsById(integer);
    }
}

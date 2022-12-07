package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.models.Order;
import com.github.MrPatronO.carworkshop.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
class OrderController {

    @Autowired
    private final OrderService orderService;

    public static final Logger logger = LoggerFactory.getLogger(CarController.class);

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    ResponseEntity<Order> readOrders(@PathVariable int orderId) {

        return orderService.findAll();
    }

    @PostMapping
    Order newOrder(@RequestBody @Validated Order newOrder) {

        return  orderService.save(newOrder);
    }

    @GetMapping("/{id}")
    Order readIdOrders(@PathVariable int orderId) {

        return orderService.findById(orderId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    Order updateOrder(@PathVariable int orderId, @RequestBody @Validated Order newOrder) {
        return orderService.findById(orderId)
                .map(order -> {
                    order.setTimetable(newOrder.getTimetable());
                    order.setCar(newOrder.getCar());
                    order.setClient(newOrder.getClient());
                    order.setDescription(newOrder.getDescription());
                    order.setPrice(newOrder.getPrice());
                    order.setStatus(newOrder.getStatus());
                    order.setStand(newOrder.getStand());

                    return orderService.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setOrderId(orderId);
                    return orderService.save(newOrder);
                })  ;

    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable int orderId) {
        orderService.deleteById(orderId);
    }
}

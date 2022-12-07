package com.github.MrPatronO.carworkshop.models;

import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int client;
    @Column(nullable = false)
    private int car;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int stand;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private int timetable;

    public Order() {
    }

    Order(int orderId, String description, int client, int car, double price, int stand, String status, int timetable) {
        this.orderId = orderId;
        this.description = description;
        this.client = client;
        this.car = car;
        this.price = price;
        this.stand = stand;
        this.status = status;
        this.timetable = timetable;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStand() {
        return stand;
    }

    public void setStand(int stand) {
        this.stand = stand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimetable() {
        return timetable;
    }

    public void setTimetable(int timetable) {
        this.timetable = timetable;
    }
}
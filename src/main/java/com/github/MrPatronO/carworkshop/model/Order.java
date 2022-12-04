package com.github.MrPatronO.carworkshop.model;

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


    public int getOrderId() {
        return orderId;
    }

    void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public int getClient() {
        return client;
    }

    void setClient(int client) {
        this.client = client;
    }

    public int getCar() {
        return car;
    }

    void setCar(int car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    public int getStand() {
        return stand;
    }

    void setStand(int stand) {
        this.stand = stand;
    }

    public String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    public int getTimetable() {
        return timetable;
    }

    void setTimetable(int timetable) {
        this.timetable = timetable;
    }
}
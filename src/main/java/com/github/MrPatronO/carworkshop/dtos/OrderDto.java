package com.github.MrPatronO.carworkshop.dtos;

import jakarta.validation.constraints.NotBlank;

class OrderDto {

    private int orderId;
    @NotBlank(message = "Description number may not be blank")
    private String description;
    @NotBlank(message = "Client id may not be blank")
    private int client;
    @NotBlank(message = "Car id may not be blank")
    private int car;
    @NotBlank(message = "Price may not be blank")
    private double price;
    @NotBlank(message = "Stand number may not be blank")
    private int stand;
    @NotBlank(message = "Status may not be blank")
    private String status;
    @NotBlank(message = "Timetable may not be blank")
    private int timetable;

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

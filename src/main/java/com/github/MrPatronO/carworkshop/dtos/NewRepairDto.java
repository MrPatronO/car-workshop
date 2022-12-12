package com.github.MrPatronO.carworkshop.dtos;


import com.github.MrPatronO.carworkshop.models.Car;
import com.github.MrPatronO.carworkshop.models.Client;
import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.models.Workplace;

import java.math.BigDecimal;

public class NewRepairDto {

    private String description;

    private Client client;

    private Car car;

    private BigDecimal price;

    private Workplace stand;

    private Timetable timetable;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Workplace getStand() {
        return stand;
    }

    public void setStand(Workplace stand) {
        this.stand = stand;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }
}

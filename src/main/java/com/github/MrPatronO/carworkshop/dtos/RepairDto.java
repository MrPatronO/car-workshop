package com.github.MrPatronO.carworkshop.dtos;

import com.github.MrPatronO.carworkshop.models.Car;
import com.github.MrPatronO.carworkshop.models.Client;
import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.models.Workplace;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class RepairDto {

    private int repairId;
    @NotBlank(message = "Description number may not be blank")
    private String description;
    @NotBlank(message = "Client id may not be blank")
    private Client client;
    @NotBlank(message = "Car id may not be blank")
    private Car car;
    @NotBlank(message = "Price may not be blank")
    private BigDecimal price;      //zmienić w pozostałych
    @NotBlank(message = "Stand number may not be blank")
    private Workplace stand;
    @NotBlank(message = "Status may not be blank")
    private String status;
    @NotBlank(message = "Timetable may not be blank")
    private Timetable timetable;

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int orderId) {
        this.repairId = repairId;
    }

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

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }
}

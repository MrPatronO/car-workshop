package com.github.MrPatronO.carworkshop.dtos;

import com.github.MrPatronO.carworkshop.models.Car;
import com.github.MrPatronO.carworkshop.models.Client;
import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.models.Workplace;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class RepairDto {

    private Long repairId;
    @NotBlank(message = "Description number may not be blank")
    private String description;
    private Client clientId;
    private Car carId;
    @NotBlank(message = "Price may not be blank")
    private BigDecimal price;
    private Workplace workplaceId;


    private Timetable timetableId;

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public Workplace getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(Workplace workplaceId) {
        this.workplaceId = workplaceId;
    }

    public Timetable getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Timetable timetableId) {
        this.timetableId = timetableId;
    }

}

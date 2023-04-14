package com.github.MrPatronO.carworkshop.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairId;

    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client")
    private Client client;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car")
    private Car car;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "workplace")
    private Workplace workplace;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "timetable")
    private Timetable timetable;


    public Repair() {
    }


    Repair(Long repairId, String description, Client client, Car car, BigDecimal price, Workplace workplace,Timetable timetable) {
        this.repairId = repairId;
        this.description = description;
        this.client = client;
        this.car = car;
        this.price = price;
        this.workplace = workplace;
        this.timetable = timetable;
    }

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

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

}
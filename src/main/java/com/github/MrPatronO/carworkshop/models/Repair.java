package com.github.MrPatronO.carworkshop.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int repairId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    @ManyToOne()
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @OneToOne()
    @JoinColumn(name = "workplace_id")
    private Workplace stand;
    /*
    zamienić na Enum, w bazie jako String
     */
    @Column(nullable = false)
    private Enum status;

    @OneToOne()
    @JoinColumn(name = "timetable_id")
    @Column(nullable = false)
    private Timetable timetable;


    public Repair() {
    }


    Repair(int repairId, String description, Client client, Car car, BigDecimal price, Workplace stand, Enum status, Timetable timetable) {
        this.repairId = repairId;
        this.description = description;
        this.client = client;
        this.car = car;
        this.price = price;
        this.stand = stand;
        this.status = status;
        this.timetable = timetable;
    }

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
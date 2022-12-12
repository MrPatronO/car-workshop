package com.github.MrPatronO.carworkshop.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workplaceId;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @OneToOne(mappedBy = "stand")
    private List<Repair> repairs;

    public Workplace() {

    }

    public int getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(int workplaceId) {
        this.workplaceId = workplaceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
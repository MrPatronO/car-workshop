package com.github.MrPatronO.carworkshop.model;

import jakarta.persistence.*;

@Entity
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workplaceId;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String description;

    Workplace() {

    }

    public int getWorkplaceId() {
        return workplaceId;
    }

    void setWorkplaceId(int workplaceId) {
        this.workplaceId = workplaceId;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }
}
package com.github.MrPatronO.carworkshop.models;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;


@Entity
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workplaceId;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "workplace")
    private List<Repair> repairs;

    public Workplace() {

    }

    Workplace(Long workplaceId, String type, String description,  List<Repair> repairs) {
        this.workplaceId = workplaceId;
        this.type = type;
        this.description = description;
        this.repairs = repairs;
    }

    public Long getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(Long workplaceId) {
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
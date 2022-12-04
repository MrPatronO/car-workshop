package com.github.MrPatronO.carworkshop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timetableId;
    @Column(nullable = false)
    private int workplace;
    @Column(nullable = false)
    private LocalDateTime startOfRepair;
    @Column(nullable = false)
    private LocalDateTime endOfRepair;


    public int getTimetableId() {
        return timetableId;
    }

    void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public int getWorkplace() {
        return workplace;
    }

    void setWorkplace(int workplace) {
        this.workplace = workplace;
    }

    public LocalDateTime getStartOfRepair() {
        return startOfRepair;
    }

    void setStartOfRepair(LocalDateTime startOfRepair) {
        this.startOfRepair = startOfRepair;
    }

    public LocalDateTime getEndOfRepair() {
        return endOfRepair;
    }

    void setEndOfRepair(LocalDateTime endOfRepair) {
        this.endOfRepair = endOfRepair;
    }
}

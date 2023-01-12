package com.github.MrPatronO.carworkshop.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import java.util.Objects;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timetableId;

    @Column(nullable = false)
    private int workplace;

    @Column(nullable = false)
    private LocalDateTime startOfRepair;

    @Column(nullable = false)
    private LocalDateTime endOfRepair;

    @OneToOne(mappedBy = "timetable")
    private Repair repairs;

    public Timetable() {
    }


    Timetable(Long timetableId, int workplace, LocalDateTime startOfRepair, LocalDateTime endOfRepair, Repair repairs) {
        this.timetableId = timetableId;
        this.workplace = workplace;
        this.startOfRepair = startOfRepair;
        this.endOfRepair = endOfRepair;
        this.repairs = repairs;
    }

    public Long getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Long timetableId) {
        this.timetableId = timetableId;
    }

    public int getWorkplace() {
        return workplace;
    }

    public void setWorkplace(int workplace) {
        this.workplace = workplace;
    }

    public LocalDateTime getStartOfRepair() {
        return startOfRepair;
    }

    public void setStartOfRepair(LocalDateTime startOfRepair) {
        this.startOfRepair = startOfRepair;
    }

    public LocalDateTime getEndOfRepair() {
        return endOfRepair;
    }

    public void setEndOfRepair(LocalDateTime endOfRepair) {
        this.endOfRepair = endOfRepair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return timetableId == timetable.timetableId && workplace == timetable.workplace && startOfRepair.equals(timetable.startOfRepair) && endOfRepair.equals(timetable.endOfRepair) && repairs.equals(timetable.repairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timetableId, workplace, startOfRepair, endOfRepair, repairs);
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "timetableId=" + timetableId +
                ", workplace=" + workplace +
                ", startOfRepair=" + startOfRepair +
                ", endOfRepair=" + endOfRepair +
                ", repairs=" + repairs +
                '}';
    }
}

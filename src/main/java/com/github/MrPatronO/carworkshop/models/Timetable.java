package com.github.MrPatronO.carworkshop.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    @OneToOne(mappedBy = "timetable")
    private List<Repair> repairs;

    public Timetable() {
    }

    Timetable(int timetableId, int workplace, LocalDateTime startOfRepair, LocalDateTime endOfRepair) {
        this.timetableId = timetableId;
        this.workplace = workplace;
        this.startOfRepair = startOfRepair;
        this.endOfRepair = endOfRepair;
    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
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
        return timetableId == timetable.timetableId && workplace == timetable.workplace && startOfRepair.equals(timetable.startOfRepair) && endOfRepair.equals(timetable.endOfRepair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.timetableId, this.workplace, this.startOfRepair, this.endOfRepair);
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "timetableId=" + timetableId +
                ", workplace=" + workplace +
                ", startOfRepair=" + startOfRepair +
                ", endOfRepair=" + endOfRepair +
                '}';
    }
}

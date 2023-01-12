package com.github.MrPatronO.carworkshop.dtos;

import java.time.LocalDateTime;

public class TimetableDto {

    private Long timetableId;

    private int workplace;

    private LocalDateTime startOfRepair;

    private LocalDateTime endOfRepair;


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
}

package com.github.MrPatronO.carworkshop.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

class TimetableDto {

    private int timetableId;
    @NotBlank(message = "Workplace id may not be blank")
    private int workplace;
    @NotBlank(message = "Start of repair may not be blank")
    private LocalDateTime startOfRepair;
    @NotBlank(message = "End of repair not be blank")
    private LocalDateTime endOfRepair;

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
}

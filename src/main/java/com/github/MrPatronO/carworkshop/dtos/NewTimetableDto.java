package com.github.MrPatronO.carworkshop.dtos;


import java.time.LocalDateTime;

public class NewTimetableDto {

    private int workplace;

    private LocalDateTime startOfRepair;

    private LocalDateTime endOfRepair;

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

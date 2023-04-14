package com.github.MrPatronO.carworkshop.dtos;


import java.time.LocalDateTime;

public class NewTimetableDto {

    private Long workplaceId;

    private LocalDateTime startOfRepair;

    private LocalDateTime endOfRepair;

    public Long getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(Long workplaceId) {
        this.workplaceId = workplaceId;
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

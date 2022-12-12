package com.github.MrPatronO.carworkshop.dtos;


import jakarta.validation.constraints.NotBlank;

public class WorkplaceDto {

    private int workplaceId;
    @NotBlank(message = "Type may not be blank")
    private String type;
    @NotBlank(message = "Description may not be blank")
    private String description;

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

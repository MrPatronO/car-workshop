package com.github.MrPatronO.carworkshop.dtos;


import jakarta.validation.constraints.NotBlank;

public class CarDto {


    private int carId;
    @NotBlank(message = "Brand may not be blank")
    private String brand;
    @NotBlank(message = "Model may not be blank")
    private String model;
    @NotBlank(message = "Vintage may not be blank")
    private int vintage;
    @NotBlank(message = "Engine may not be blank")
    private double engine;
    @NotBlank(message = "Type Fuel may not be blank")
    private String typeFuel;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public String getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }
}

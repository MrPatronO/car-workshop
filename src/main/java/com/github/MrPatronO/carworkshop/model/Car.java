package com.github.MrPatronO.carworkshop.model;


import jakarta.persistence.*;

@Entity
public class Car {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int carId;
        @Column(nullable = false)
        private String brand;
        @Column(nullable = false)
        private String model;
        @Column(nullable = false)
        private int vintage;
        @Column(nullable = false)
        private double engine;
        @Column(nullable = false)
        private String typeFuel;


        public int getCarId() {
            return carId;
        }

        void setCarId(int carId) {
            this.carId = carId;
        }

        public String getBrand() {
            return brand;
        }

        void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        void setModel(String model) {
            this.model = model;
        }

        public int getVintage() {
            return vintage;
        }

        void setVintage(int vintage) {
            this.vintage = vintage;
        }

        public double getEngine() {
            return engine;
        }

        void setEngine(double engine) {
            this.engine = engine;
        }

        public String getTypeFuel() {
            return typeFuel;
        }

        void setTypeFuel(String typeFuel) {
            this.typeFuel = typeFuel;
        }


}



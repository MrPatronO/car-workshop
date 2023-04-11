package com.github.MrPatronO.carworkshop.models;


import com.github.MrPatronO.carworkshop.dtos.CarDto;
import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;


@Entity
public class Car {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long carId;
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

        @OneToMany(mappedBy = "car")
        private List<Repair> repairs;

    public Car() {
    }

    Car(Long carId, String brand, String model, int vintage, double engine, String typeFuel, List<Repair> repairs) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.vintage = vintage;
        this.engine = engine;
        this.typeFuel = typeFuel;
        this.repairs = repairs;
    }


    public Long getCarId() {
            return carId ;
        }

        public void setCarId(Long carId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId && vintage == car.vintage && Double.compare(car.engine, engine) == 0 && brand.equals(car.brand) && model.equals(car.model) && typeFuel.equals(car.typeFuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.carId, this.brand, this.model, this.vintage, this.engine, this.typeFuel);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", vintage=" + vintage +
                ", engine=" + engine +
                ", typeFuel='" + typeFuel + '\'' +
                '}';
    }
}



package design.parkinglot.model.slot;

public class Vehicle {
    private String color;
    private Integer registrationNumber;

    public Vehicle(String color, Integer registrationNumber){
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public Integer getRegistrationNumber() {
        return registrationNumber;
    }
}

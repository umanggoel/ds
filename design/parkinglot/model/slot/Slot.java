package design.parkinglot.model.slot;

public class Slot {

    private Integer slotNumber;
    private Vehicle parkedVehicle;

    public Slot(Integer slotNumber){
        this.slotNumber = slotNumber;
    }
    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Vehicle getParkedCar() {
        return parkedVehicle;
    }

    public void setParkedCar(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public Boolean isParked(){
        return !(parkedVehicle ==null);
    }
}

package ru.job4j.parking;

public class ParkController {
    private Parking parking;
    private int pass;
    private int truck;


    public ParkController(int pass, int truck) {
        this.parking = new AutoParking(pass, truck);
        this.pass = pass;
        this.truck = truck;
    }

    public void parkingVehicle(Vehicle vehicle) {
       if (checkEmptySeat(vehicle.getSize())) {
           this.parking.addVehicle(vehicle);
       } else {
           throw new IndexOutOfBoundsException("Нет свободных мест");
       }
    }

    private boolean checkEmptySeat(int size) {
        if (size > 1) {
            if (this.truck > 0) {
                this.truck--;
                return true;
            } else if (this.pass >= size) {
                this.pass =  this.pass - size;
                return true;
            } else {
                return false;
            }
        } else if (this.pass > size) {
                this.pass = this.pass - size;
                return true;
        } else {
            return false;
        }
    }

    public void goOutVehicle(int seat) {
        int i = this.parking.getList().get(seat).getSize();
        this.parking.deleteVehicle(seat);
        if (i > 1) {
            this.truck = this.truck + i;
        } else {
            this.pass++;
        }
    }

    public Vehicle getVehicleBySeat(int seat) {
        return this.parking.getList().get(seat);
    }
}

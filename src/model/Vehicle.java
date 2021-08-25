package model;

import java.io.IOException;

public abstract class Vehicle {
    private String vehicleNo;
    private String vehicleType;
    private String maxWeight;
    private int noOfPassengers;

    public Vehicle() {
    }

    public Vehicle(String vehicleNo, String vehicleType, String maxWeight, int noOfPassengers) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.noOfPassengers = noOfPassengers;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(String maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public String toString() {
        return vehicleNo+" "+vehicleType;
    }

    abstract public int park(String vehicleNo,String vehicleType) throws IOException;

}

package sdp.example.vehicle;

public class Vehicle {

    private String manufacturer;
    private double maxSpeed;

    public Vehicle(String manufacturer, double maxSpeed) {
        this.manufacturer = manufacturer;
        this.maxSpeed = maxSpeed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

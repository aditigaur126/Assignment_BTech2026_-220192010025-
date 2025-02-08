// Write a Java program to create a class called "Vehicle" with attributes for make, model, and year. Create subclasses "Car" and "Truck" that add specific attributes like trunk size for cars and payload capacity for trucks. Implement a method to display vehicle details in each subclass.
package oops;

class Vehicle {
    private String make;
    private String model;
    private int yr;

    public Vehicle(String make, String model, int yr) {
        this.make = make;
        this.model = model;
        this.yr = yr;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return yr;
    }

    public void displayDetails() {
        System.out.println("Make is: " + getMake());
        System.out.println("Model is: " + getModel());
        System.out.println("Year is: " + getYear());
    }

}

class Car extends Vehicle {
    private int trunksize;

    public Car(String make, String model, int yr, int trunksize) {
        super(make, model, yr);
        this.trunksize = trunksize;
    }

    public void setTrunkSize(int trunksize) {
        if (trunksize > 0) {
            this.trunksize = trunksize;
        } else {
            System.out.println("Trunk Size must be positive");
        }
    }

    public int getTrunkSize() {
        return trunksize;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Trunk Size: " + getTrunkSize());
    }
}

class Truck extends Vehicle {
    private int payload;

    public Truck(String make, String model, int yr, int payload) {
        super(make, model, yr);
        this.payload = payload;
    }

    public void setPayload(int payload) {
        if (payload > 0) {
            this.payload = payload;
        } else {
            System.out.println("Payload Capacity must be positive");
        }
    }

    public int getPayload() {
        return payload;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Payload Capacity: " + getPayload());
    }
}

public class prog10 {
    public static void main(String[] args) {
        Car car = new Car("Suzuki", "Swift", 2015, 15);
        car.displayDetails();
        Truck truck = new Truck("Suzuki", "Swift", 2015, 15);
        truck.displayDetails();
    }
}

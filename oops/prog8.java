//Write a Java program to create class called "TrafficLight" with attributes for color and duration, and methods to change the color and check for red or green.
package oops;

class TrafficLight {
    private String color;
    private int duration;

    public TrafficLight(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    public void changeColor(String color) {
        this.color = color;
        System.out.println("Signal turned " + color);
    }

    public String getColor() {
        if (color == "red" || color == "Red" || color == "RED") {
            System.out.println("STOP");
        }
        if (color == "Yellow" || color == "yellow" || color == "YELLOW") {
            System.out.println("WAIT");
        }
        if (color == "green" || color == "Green" || color == "GREEN") {
            System.out.println("GO");
        }

        return color;
    }

    public boolean isRed() {

        return color == "red" || color == "Red" || color == "RED";
    }

    public boolean isYellow() {

        return color == "Yellow" || color == "yellow" || color == "YELLOW";
    }

    public boolean isGreen() {

        return color == "green" || color == "Green" || color == "GREEN";
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

}

// duration in secs
public class prog8 {
    public static void main(String[] args) {
        TrafficLight s1 = new TrafficLight("red", 10);
        System.out.println(s1.getColor());
        System.out.println("Duration is: " + s1.getDuration());
        s1.changeColor("Green");
        if (s1.isGreen()) {
            System.out.println("Signal is Green");
        }
        s1.setDuration(20);
        System.out.println(s1.getColor());
        System.out.println("DUration is: " + s1.getDuration());

    }

}

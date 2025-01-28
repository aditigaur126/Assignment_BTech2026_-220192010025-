//Write a Java program to create a class called "Rectangle" with width and height attributes.
// Calculate the area and perimeter of the rectangle.
package oops;

import java.util.*;

class Rectangle {
    private int width;
    private int height;

    public void set(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getArea() {
        return width * height;
    }
}

public class prog3 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.set(15, 320);
        System.out.println("Area is : " + r.getArea());
    }
}

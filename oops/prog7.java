//Write a Java program to create a class called "Shape" with abstract methods for calculating area and perimeter, and subclasses for "Rectangle","Square", "Circle", and "Triangle".
package oops;

abstract class Shape {
    public abstract double getPerimeter();

    public abstract double getArea();
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getPerimeter() {
        return (length + width) * 2;
    }

    public double getArea() {
        return length * width;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getPerimeter() {
        return 4 * side;
    }

    public double getArea() {
        return side * side;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

}

class Triangle extends Shape {
    private double s1, s2, s3;

    public Triangle(double s1, double s2, double s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

    }

    public double getPerimeter() {
        return s1 + s2 + s3;
    }

    public double getArea() {
        double s = (s1 + s2 + s3) / 2;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }
}

public class prog7 {
    public static void main(String[] args) {

        Shape rect = new Rectangle(5, 8);
        Shape sq = new Square(5);
        Shape cir = new Circle(8);
        Shape tri = new Triangle(5, 8, 10);
        System.out.println("Rectangle Area : " + rect.getArea() + " Perimeter : " +
                rect.getPerimeter());
        System.out.println("Square   Area : " + sq.getArea() + " Perimeter : " + sq.getPerimeter());
        System.out.println("Circle   Area : " + cir.getArea() + " Perimeter : " + cir.getPerimeter());
        System.out.println("Triangle   Area : " + tri.getArea() + " Perimeter : " + tri.getPerimeter());
    }
}

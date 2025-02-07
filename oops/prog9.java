//Write a Java program to create a class called "Student" with a name, grade, and courses attributes, and methods to add and remove courses.
package oops;

import java.util.ArrayList;

class Student {
    private String name;
    private int grade;
    private ArrayList<String> courses;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.courses = new ArrayList<>();
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void changeGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public ArrayList getCourses() {
        return courses;
    }

    public void info() {
        System.out.println("Name of the student:" + getName());
        System.out.println("Grade: " + getGrade());
        System.out.println("Enrolled courses are:" + getCourses());
    }

}

public class prog9 {
    public static void main(String[] args) {
        Student s1 = new Student("Rahul", 10);
        s1.addCourse("English");
        s1.addCourse("Hindi");
        s1.info();
        Student s2 = new Student("Vimal", 8);
        s2.getName();
        s2.getGrade();
        s2.changeName("Vinod");
        s2.changeGrade(9);
        s2.info();

    }

}

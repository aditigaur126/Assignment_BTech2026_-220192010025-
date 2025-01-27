//Write a Java program to create a class called "Person" with a name and age attribute.
// Create two instances of the "Person" class, set their attributes using the constructor, and print their name and age.
package oops;

class Person {
    private String name;
    private int age;

    public void set(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class prog1 {
    public static void main(String args[]) {
        Person person = new Person();
        person.set("Aditi", 21);
        System.out.println("name is :" + person.getName());
        System.out.println("age is :" + person.getAge());
    }
}

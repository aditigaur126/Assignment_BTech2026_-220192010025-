//Write a Java program to create a class called "Dog" with a name and breed attribute.
//Create two instances of the "Dog" class, set their attributes using the constructor and modify the attributes using the setter methods and print the updated values.
package oops;

import java.util.*;

class Dog {
    private String name;
    private String breed;

    public void set(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

}

public class prog2 {
    public static void main(String args[]) {
        Dog d = new Dog();
        Scanner sc = new Scanner(System.in);
        d.set("tom", "abc");
        System.out.println("name is :" + d.getName());
        System.out.println("breed is :" + d.getBreed());
        d.updateName("jerry");
        d.updateBreed("xyz");
        System.out.println("updated name is :" + d.getName());
        System.out.println("updated breed is :" + d.getBreed());
        System.out.println("Enter the name and breed to be updated");
        d.updateName(sc.nextLine());
        d.updateBreed(sc.nextLine());
        System.out.println("updated name is :" + d.getName());
        System.out.println("updated breed is :" + d.getBreed());
    }
}

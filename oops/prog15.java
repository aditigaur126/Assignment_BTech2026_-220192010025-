//Write a Java program to create a class called "Restaurant" with attributes for menu items, prices, and ratings, and methods to add and remove items, and to calculate average rating.
package oops;

import java.util.*;

class Item {
    private String name;
    private double price;
    private double rating = 0.0;
    private int count = 0;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public String getItem() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {

        return rating;
    }

    public String check() {
        if (count == 0) {
            return " (has not been rated yet)";
        }
        return " ";
    }

    public void rate(double rate) {
        if (count == 0) {
            count++;
            this.rating = rate;

        } else {
            count++;
            this.rating = (this.rating + rate) / count;
        }

    }

}

class Menu {
    private ArrayList<Item> items;

    public Menu() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void display() {
        System.out.println("Menu card is as follows:");
        for (Item i : items) {
            System.out
                    .println("Name " + i.getItem() + " Price " + i.getPrice() + " Rated " + i.getRating() + i.check());
        }
    }

}

public class prog15 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Item i1 = new Item("Pasta", 100.0);
        Item i2 = new Item("Pizza", 200.0);
        Item i3 = new Item("Noodles", 80.0);
        menu.addItem(i1);
        menu.addItem(i2);
        menu.addItem(i3);
        menu.display();
        i1.rate(9.7);
        i2.rate(9.7);
        i2.rate(9.0);
        menu.display();
    }

}

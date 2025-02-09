//Write a Java program to create a class called "Movie" with attributes for title, director, actors, and reviews, and methods for adding and retrieving reviews.
package oops;

import java.util.*;

class Movie {
    private String title;
    private String director;
    private ArrayList<String> actors;
    private ArrayList<Review> reviews;

    public Movie(String title, String director, ArrayList<String> actors) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.reviews = new ArrayList<>();
    }

    public void addActor(String actor) {
        this.actors.add(actor);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void display() {
        System.out.println("Movie : " + this.title);
        System.out.println("Director : " + this.director);
        System.out.println("Actors : " + this.actors);
        System.out.println("Reviews : ");
        for (Review r : reviews) {
            System.out.println(r);
        }

    }

}

class Review {
    private String text;
    private double rating;

    public Review(String text, double rating) {
        this.text = text;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public double getRating() {
        return rating;
    }

    // to make Review object human readable
    @Override

    public String toString() {
        return ("FeedBack : " + getText() + " Rating : " + getRating());
    }

}

public class prog11 {
    public static void main(String[] args) {
        Movie m1 = new Movie("ab", "bc", new ArrayList(Arrays.asList("babs", "asxc")));
        Review r1 = new Review("very nyc", 4.0);
        Review r2 = new Review("very nyc", 4.0);
        m1.addReview(r1);
        m1.addReview(r2);
        m1.addActor("jaypee");
        m1.display();

    }
}
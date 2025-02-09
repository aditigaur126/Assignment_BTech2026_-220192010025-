//Write a Java program to create a class called "Library" with a collection of books and methods to add and remove books.
package oops;

import java.util.*;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}

class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public void addBooks(Book book) {
        this.books.add(book);
        System.out.println(book.getTitle() + " is added");
    }

    public void removeBooks(Book book) {

        this.books.remove(book);
        System.out.println(book.getTitle() + " is removed");
    }

    public void display() {
        System.out.println("Books in the Library are as follows:");
        for (Book b : books) {
            System.out.println("Title : " + b.getTitle() + " Author : " + b.getAuthor());
        }
    }
}

public class prog12 {
    public static void main(String[] args) {
        Library lib = new Library();
        Book b1 = new Book("merchant of venice", "Shakespeare");
        Book b2 = new Book("moments", "unknown");
        lib.addBooks(b1);
        lib.addBooks(b2);
        lib.display();
        lib.removeBooks(b2);
        lib.display();
    }
}
//Write a Java program to create a class called "Book" 
//with attributes for title, author, and ISBN, and methods to add and remove books from a collection.
package oops;

import java.util.*;

class Book {
    private String title;
    private String author;
    private int ISBN;
    private static ArrayList<Book> books = new ArrayList<Book>();

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsbn(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getIsbn() {
        return ISBN;
    }

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void removeBook(Book book) {
        books.remove(book);
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

}

public class prog4 {
    public static void main(String[] args) {
        Book b1 = new Book("math", "abc", 123);
        Book b2 = new Book("science", "pvc", 456);
        Book.addBook(b1);
        Book.addBook(b2);
        ArrayList<Book> books = Book.getBooks();
        for (Book book : books) {
            System.out
                    .println("Title: " + book.getTitle() + "Author: " + book.getAuthor() + " ISBN :" + book.getIsbn());
        }
        Book.removeBook(b1);
        System.out.println("Books now after removal:");

        for (Book book : books) {
            System.out
                    .println("Title: " + book.getTitle() + " Author: " + book.getAuthor() + " ISBN :" + book.getIsbn());
        }

    }

}

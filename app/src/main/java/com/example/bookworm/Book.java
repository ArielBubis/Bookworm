package com.example.bookworm;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
/**
 * This class represents a book with a title, author, image resource, and expected return date.
 */
public class Book {
    private String title; // The title of the book
    private String author; // The author of the book
    private int imageResource; // The resource ID of the book's image
    private Date expectedReturnDate; // The expected return date of the book

//    public Book() {
//        title = "test";
//        author = "test";
//        imageResource = R.drawable.logo_temp;
//        expectedReturnDate  = new Date(3000,1,1);
//    }

    /**
     * Constructor for the Book class.
     * It initializes the title, author, image resource, and expected return date.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        imageResource = R.drawable.logo_temp;
        expectedReturnDate  = new Date(3000,1,1);

    }

    /**
     * Returns the expected return date of the book.
     */
    public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }

    /**
     * Sets the expected return date of the book.
     */
    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    /**
     * Returns the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the image resource of the book.
     */
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    /**
     * Returns the author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the image resource of the book.
     */
    public int getImageResource() {
        return imageResource;
    }
}
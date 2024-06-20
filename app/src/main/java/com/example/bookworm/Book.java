package com.example.bookworm;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private int imageResource;
    private Date expectedReturnDate;

//    public Book() {
//        title = "test";
//        author = "test";
//        imageResource = R.drawable.logo_temp;
//        expectedReturnDate  = new Date(3000,1,1);
//    }
    public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        imageResource = R.drawable.logo_temp;
        expectedReturnDate  = new Date(3000,1,1);

    }

    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getAuthor() {
        return author;
    }

    public int getImageResource() {
        return imageResource;
    }

}
package com.example.bookworm;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private int imageResource;
    private Date expectedReturnDate;

    protected Book() {
        title = "test";
        author = "test";
        imageResource = R.id.book_image;
        expectedReturnDate  = null;
    }
    public Date getExpectedReturnDate() {
        return expectedReturnDate;
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
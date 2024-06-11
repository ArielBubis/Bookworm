package com.example.bookworm;

public class Book {
    private String title;
    private String author;
    private int imageResource; // This could be a drawable resource ID for the book's image

    public Book(String title, String author, int imageResource) {
        this.title = title;
        this.author = author;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getImageResource() {
        return imageResource;
    }
}


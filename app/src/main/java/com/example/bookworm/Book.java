package com.example.bookworm;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title;
    private String author;
    private int imageResource;

    // Constructor and other methods...

    protected Book(Parcel in) {
        title = in.readString();
        author = in.readString();
        imageResource = in.readInt();
    }
    protected Book() {
        title = "test";
        author = "test";
        imageResource = R.id.book_image;
    }
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeInt(imageResource);
    }
}
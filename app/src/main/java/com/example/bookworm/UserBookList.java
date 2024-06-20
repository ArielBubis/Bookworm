package com.example.bookworm;

import java.util.ArrayList;
import java.util.List;

public class UserBookList {
    private static UserBookList instance = null;
    private List<Book> userBooks;

    private UserBookList() {
        userBooks = new ArrayList<>();
    }

    public static UserBookList getInstance() {
        if (instance == null) {
            instance = new UserBookList();
        }
        return instance;
    }

    public List<Book> getUserBooks() {
        return userBooks;
    }

    public void addUserBook(Book book) {
        userBooks.add(book);
    }

    public void removeUserBook(Book book) {
        userBooks.remove(book);
    }
}
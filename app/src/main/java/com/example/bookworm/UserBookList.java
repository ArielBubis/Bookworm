package com.example.bookworm;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a singleton list of books that the user has.
 * Singleton means that there can only be one instance of this class in the application.
 */
public class UserBookList {
    // The single instance of this class
    private static UserBookList instance = null;

    // The list of books that the user has
    private List<Book> userBooks;

    /**
     * Private constructor for the UserBookList.
     * It initializes the list of user books.
     * It's private to prevent creating more than one instance of this class.
     */
    private UserBookList() {
        userBooks = new ArrayList<>();
    }

    /**
     * Returns the single instance of this class.
     * If the instance doesn't exist, it creates one.
     */
    public static UserBookList getInstance() {
        if (instance == null) {
            instance = new UserBookList();
        }
        return instance;
    }

    /**
     * Returns the list of books that the user has.
     */
    public List<Book> getUserBooks() {
        return userBooks;
    }

    /**
     * Adds a book to the list of user books.
     */
    public void addUserBook(Book book) {
        userBooks.add(book);
    }

    /**
     * Removes a book from the list of user books.
     */
    public void removeUserBook(Book book) {
        userBooks.remove(book);
    }
}
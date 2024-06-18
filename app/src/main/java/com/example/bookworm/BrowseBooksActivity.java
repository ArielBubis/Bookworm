package com.example.bookworm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BrowseBooksActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookAdapter booksAdapter;
    private ArrayList<Book> booksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_books);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize booksList and booksAdapter
        booksList = new ArrayList<>();
        booksList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", R.drawable.logo_temp));

        booksAdapter = new BookAdapter(booksList, this);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(booksAdapter);

        // Load books into booksList
        loadBooks();
    }

    private void loadBooks() {
        // Load books into booksList
    }
}


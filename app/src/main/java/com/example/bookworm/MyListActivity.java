package com.example.bookworm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookAdapter booksAdapter;
    private ArrayList<Book> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize myList and booksAdapter
        BookAdapter booksAdapter = new BookAdapter();

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(booksAdapter);

        // Load books into myList
        loadMyList();
    }

    private void loadMyList() {
        // Load books into myList
    }
}

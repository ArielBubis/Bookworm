package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

/**
 * This class represents the activity where users can view their list of books.
 */
public class MyListActivity extends AppCompatActivity {
    // The RecyclerView that displays the books
    private RecyclerView recyclerView;

    // The adapter for the RecyclerView
    private ListAdapter listAdapter;

    // The button that navigates to the BrowseBooksActivity
    private Button browseBooksButton;

    // The TextView that displays the name of the app
    private TextView appName;

    /**
     * This method is called when the activity is created.
     * It initializes the RecyclerView, the ListAdapter, and the buttons.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize myList and listAdapter
        listAdapter = new ListAdapter();

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(listAdapter);

        // Set up the app name TextView
        appName = findViewById(R.id.appName);
        appName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When clicked, it starts the MainActivity
                Intent intent = new Intent(MyListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set up the browse books button
        browseBooksButton = findViewById(R.id.browseBooksButton);
        browseBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When clicked, it starts the BrowseBooksActivity
                Intent intent = new Intent(MyListActivity.this, BrowseBooksActivity.class);
                startActivity(intent);
            }
        });

        // Check if any books are late
        for (Book book : UserBookList.getInstance().getUserBooks()) {
            if (new Date().after(book.getExpectedReturnDate())) {
                // If a book is late, show a Toast message
                Toast.makeText(this, "LATE!! The book "+book.getTitle()+" was supposed to be returned on: " + book.getExpectedReturnDate(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
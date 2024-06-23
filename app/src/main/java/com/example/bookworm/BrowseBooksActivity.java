package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * This class represents the activity where users can browse books.
 */
public class BrowseBooksActivity extends AppCompatActivity {
    private RecyclerView recyclerView; // The RecyclerView that displays the books
    private BookAdapter booksAdapter; // The adapter for the RecyclerView

    private Button myListButton; // The button that takes the user to their list of books

    private Button filterButton; // The button that opens the filter dialog
    private Button clear_FilterButton; // The button that clears the current filter

    private TextView appName; // The TextView that displays the name of the app

    /**
     * This method is called when the activity is created.
     * It initializes the RecyclerView, the BookAdapter, and the buttons.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_books);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        // Initialize booksAdapter
        booksAdapter = new BookAdapter(); // Initialize the field here
        recyclerView.setAdapter(booksAdapter);

        // Set up the filter button
        filterButton = findViewById(R.id.button_Filter);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the FilterBooksFragment dialog
                FilterBooksFragment filterFragment = new FilterBooksFragment();
                filterFragment.setBooksAdapter(booksAdapter);
                filterFragment.setOnFilterAppliedListener(new FilterBooksFragment.OnFilterAppliedListener() {
                    @Override
                    public void onFilterApplied(List<Book> filteredBooks) {
                        // Update the RecyclerView with the filtered book list
                        booksAdapter.updateDataset(filteredBooks);
                    }
                });

                filterFragment.show(getSupportFragmentManager(), "FilterBooksFragment");
            }
        });

        // Set up the clear filter button
        clear_FilterButton = findViewById(R.id.button_Clear);
        clear_FilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> allBooks = booksAdapter.getAllBooks();
                Log.d("BrowseBooksActivity", "Clear filter button clicked. Resetting book list."+allBooks.size());
                booksAdapter.updateDataset(allBooks);
            }
        });

        // Set up the app name TextView
        appName = findViewById(R.id.appName);
        appName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrowseBooksActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set up the my list button
        myListButton = findViewById(R.id.myListButton);
        myListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrowseBooksActivity.this, MyListActivity.class);
                startActivity(intent);
            }
        });
    }
}
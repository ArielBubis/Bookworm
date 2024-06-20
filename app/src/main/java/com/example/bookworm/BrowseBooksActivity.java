package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BrowseBooksActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookAdapter booksAdapter; // This is a field of the class

    private Button filterButton;
    private Button clear_FilterButton;

    private TextView appName;

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
        booksAdapter = BookAdapter.getInstance(); // Initialize the field here
        recyclerView.setAdapter(booksAdapter);

        // Inside your BrowseBooksActivity
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
        clear_FilterButton = findViewById(R.id.button_Clear);
        clear_FilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> allBooks = booksAdapter.getAllBooks();
                Log.d("BrowseBooksActivity", "Clear filter button clicked. Resetting book list."+allBooks.size());
                booksAdapter.updateDataset(allBooks);
            }
        });

        appName = findViewById(R.id.appName);
        appName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrowseBooksActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
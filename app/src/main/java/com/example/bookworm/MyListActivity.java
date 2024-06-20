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

import java.util.ArrayList;
import java.util.Date;

public class MyListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    private Button browseBooksButton;

    private TextView appName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize myList and booksAdapter
        listAdapter = new ListAdapter();

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(listAdapter);
        appName = findViewById(R.id.appName);
        appName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        browseBooksButton = findViewById(R.id.browseBooksButton);
        browseBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyListActivity.this, BrowseBooksActivity.class);
                startActivity(intent);
            }
        });

        for (Book book : UserBookList.getInstance().getUserBooks()) {
            if (new Date().after(book.getExpectedReturnDate())) {
                Toast.makeText(this, "LATE!! The book "+book.getTitle()+" was supposed to be returned on: " + book.getExpectedReturnDate(), Toast.LENGTH_LONG).show();
            }
        }

    }

}

package com.example.bookworm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class represents the main activity of the application.
 * It contains buttons to navigate to the BrowseBooksActivity and MyListActivity.
 */
public class MainActivity extends AppCompatActivity {
    // Button to navigate to the BrowseBooksActivity
    private Button browseBooksButton;

    // Button to navigate to the MyListActivity
    private Button myListButton;

    /**
     * This method is called when the activity is created.
     * It initializes the buttons and sets their onClickListeners.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        browseBooksButton = findViewById(R.id.browseBooksButton);
        myListButton = findViewById(R.id.myListButton);

        // Set onClickListener for the browseBooksButton
        // When clicked, it starts the BrowseBooksActivity
        browseBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowseBooksActivity.class);
                startActivity(intent);
            }
        });

        // Set onClickListener for the myListButton
        // When clicked, it starts the MyListActivity
        myListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyListActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.bookworm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button browseBooksButton;
    private Button myListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons and set onClickListeners
        browseBooksButton = findViewById(R.id.browseBooksButton);
        myListButton = findViewById(R.id.myListButton);

        browseBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start BrowseBooksActivity
            }
        });

        myListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MyListActivity
            }
        });
    }
}

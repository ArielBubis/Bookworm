package com.example.bookworm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
                Intent intent = new Intent(MainActivity.this, BrowseBooksActivity.class);
                startActivity(intent);
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

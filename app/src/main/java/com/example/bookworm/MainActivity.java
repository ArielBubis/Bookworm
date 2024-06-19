package com.example.bookworm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        FragmentManager fm = getSupportFragmentManager();
        Welcome_Fragment welcome = new Welcome_Fragment();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.root_layout, welcome);
        t.addToBackStack(null);
        t.commit();

        browseBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send data to fragment

            }
        });
        myListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

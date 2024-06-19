package com.example.bookworm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button browseBooksButton;
    private Button myListButton;

    private TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons and set onClickListeners
        browseBooksButton = (Button)findViewById(R.id.browseBooksButton);
        myListButton = (Button)findViewById(R.id.myListButton);
        appName = (TextView)findViewById(R.id.appName);
        FragmentManager fm = getSupportFragmentManager();
        Welcome_Fragment welcome = new Welcome_Fragment();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.root_layout, welcome);
        t.addToBackStack(null);
        t.commit();

        browseBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                BrowseBooksFragment browseBooks = new BrowseBooksFragment();
                FragmentTransaction t = fm.beginTransaction();
                t.replace(R.id.root_layout, browseBooks);
                t.addToBackStack(null);
                t.commit();
            }
        });
        myListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        appName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Welcome_Fragment welcome_fragment = new Welcome_Fragment();
                FragmentTransaction t = fm.beginTransaction();
                t.replace(R.id.root_layout, welcome_fragment);
                t.addToBackStack(null);
                t.commit();
            }
        });
    }
}

package com.example.bookworm;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Welcome_Fragment extends Fragment {
    private Button browseBooksButton;
    private Button myListButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        // Initialize buttons and set onClickListeners
        browseBooksButton = view.findViewById(R.id.browseBooksButton);
        myListButton = view.findViewById(R.id.myListButton);

//        browseBooksButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(WelcomeActivity.this, BrowseBooksActivity.class);
////                startActivity(intent);
////            }
//        });


        myListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MyListActivity
            }
        });
        return view;
    }
}

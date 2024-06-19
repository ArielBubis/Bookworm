package com.example.bookworm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterBooksFragment extends DialogFragment {
    private Spinner authorSpinner;
    private Button okButton;
    private OnFilterAppliedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_filter_books, container, false);

        // Initialize views
        authorSpinner = rootView.findViewById(R.id.authorSpinner);
        okButton = rootView.findViewById(R.id.okButton);
        // Get the list of books from the arguments
        ArrayList<Book> books = getArguments().getParcelableArrayList("bookList");

        // Extract the authors from the list of books
        Set<String> authorsSet = new HashSet<>();
        for (Book book : books) {
            authorsSet.add(book.getAuthor());
        }
        List<String> authors = new ArrayList<>(authorsSet);

// Add default text to the beginning of the list
        authors.add(0, "Select an author");

// Create an ArrayAdapter using the list of authors
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, authors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        authorSpinner.setAdapter(adapter);

        // Handle OK button click
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedAuthor = authorSpinner.getSelectedItem().toString();

                // Filter the book list
                List<Book> filteredBooks = new ArrayList<>();
                for (Book book : books) {
                    if (book.getAuthor().equals(selectedAuthor)) {
                        filteredBooks.add(book);
                    }
                }

                // Call the listener
                if (listener != null) {
                    listener.onFilterApplied(filteredBooks);
                }

                // Dismiss the dialog
                dismiss();
            }
        });

        return rootView;
    }

    public void setOnFilterAppliedListener(OnFilterAppliedListener listener) {
        this.listener = listener;
    }

    public interface OnFilterAppliedListener {
        void onFilterApplied(List<Book> filteredBooks);
    }
}
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
import java.util.List;
import java.util.Set;

/**
 * This class represents a dialog fragment where users can filter books by author.
 */
public class FilterBooksFragment extends DialogFragment {
    private Spinner authorSpinner; // The spinner that displays the authors
    private Button okButton; // The button that applies the filter
    private OnFilterAppliedListener listener; // The listener that gets called when the filter is applied
    private BookAdapter booksAdapter; // The adapter for the RecyclerView that displays the books

    /**
     * This method is called when the view is created.
     * It initializes the spinner, the button, and the adapter.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_filter_books, container, false);

        // Initialize views
        authorSpinner = rootView.findViewById(R.id.authorSpinner);
        okButton = rootView.findViewById(R.id.okButton);

        // Get the list of authors from the booksAdapter
        Set<String> authors = booksAdapter.getAuthors();
        List<String> authorsList = new ArrayList<>(authors);

        // Create an ArrayAdapter using the list of authors
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, authorsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        authorSpinner.setAdapter(adapter);

        // Handle OK button click
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedAuthor = authorSpinner.getSelectedItem().toString();

                // Filter the book list by the selected author
//                List<Book> allBooks = booksAdapter.getAllBooks();
                List<Book> filteredBooks = booksAdapter.filterBooksByAuthor(selectedAuthor);

                // Call the listener
                if (listener != null) {
                    listener.onFilterApplied(filteredBooks);
                }
                dismiss();
            }
        });

        return rootView;
    }

    /**
     * Sets the listener that gets called when the filter is applied.
     */
    public void setOnFilterAppliedListener(OnFilterAppliedListener listener) {
        this.listener = listener;
    }

    /**
     * This interface represents a listener that gets called when the filter is applied.
     */
    public interface OnFilterAppliedListener {
        void onFilterApplied(List<Book> filteredBooks);
    }

    /**
     * Sets the adapter for the RecyclerView that displays the books.
     */
    public void setBooksAdapter(BookAdapter booksAdapter) {
        this.booksAdapter = booksAdapter;
    }
}
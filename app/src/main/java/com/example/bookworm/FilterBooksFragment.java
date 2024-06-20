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

public class FilterBooksFragment extends DialogFragment {
    private Spinner authorSpinner;
    private Button okButton;
    private OnFilterAppliedListener listener;
    private BookAdapter booksAdapter; // Add this line

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_filter_books, container, false);

        // Initialize views
        authorSpinner = rootView.findViewById(R.id.authorSpinner);
        okButton = rootView.findViewById(R.id.okButton);
        // Get the list of books from the arguments
        List<String> authors = booksAdapter.getAuthors();

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
                List<Book> allBooks = booksAdapter.getAllBooks();
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

    public void setOnFilterAppliedListener(OnFilterAppliedListener listener) {
        this.listener = listener;
    }

    public interface OnFilterAppliedListener {
        void onFilterApplied(List<Book> filteredBooks);
    }

    public void setBooksAdapter(BookAdapter booksAdapter) {
        this.booksAdapter = booksAdapter;
    }

}
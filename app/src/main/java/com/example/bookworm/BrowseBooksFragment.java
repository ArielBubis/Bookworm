package com.example.bookworm;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowseBooksFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookAdapter booksAdapter;

    private Button filterButton;

    private Button clear_FilterButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_browse_books, container, false);
        // Initialize RecyclerView
        recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        // Initialize booksAdapter
        List<Book> list = createList(10);
        booksAdapter = new BookAdapter(createList(10), getActivity());
        booksAdapter.updateDataset(list);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(booksAdapter);
        // Inside your BrowseBooksFragment
        filterButton = rootView.findViewById(R.id.button_Filter);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the FilterBooksFragment dialog
                FilterBooksFragment filterFragment = new FilterBooksFragment();
                filterFragment.setOnFilterAppliedListener(new FilterBooksFragment.OnFilterAppliedListener() {
                    @Override
                    public void onFilterApplied(List<Book> filteredBooks) {
                        // Update the RecyclerView with the filtered book list
                        booksAdapter.updateDataset(filteredBooks);
                    }
                });                Bundle args = new Bundle();
                args.putParcelableArrayList("bookList", (ArrayList<? extends Parcelable>) list);
                filterFragment.setArguments(args);
                filterFragment.show(getChildFragmentManager(), "FilterDialog");
            }
        });
        clear_FilterButton = rootView.findViewById(R.id.button_Clear);
        clear_FilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booksAdapter.updateDataset(list);
            }
        });

        // Load books into booksList
        return rootView;
    }

    private List<Book> createList(int size) {

        List<Book> result = new ArrayList<>();
        for (int i=1; i <= size; i++) {
            Book b = new Book();
            b.setTitle(i + "asdasd");
            b.setAuthor(i + "asdasd");
            b.setImageResource(R.drawable.logo_temp);

            result.add(b);

        }

        return result;
    }

}

package com.example.bookworm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class BrowseBooksActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BooksAdapter booksAdapter;
    private ArrayList<Book> booksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_books);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize booksList and booksAdapter
        booksList = new ArrayList<>();
        booksAdapter = new BooksAdapter(booksList, this);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(booksAdapter);

        // Load books into booksList
        loadBooks();
    }

    private void loadBooks() {
        // Load books into booksList
    }
}


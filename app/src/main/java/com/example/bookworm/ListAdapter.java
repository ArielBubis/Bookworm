package com.example.bookworm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This class is an adapter for the RecyclerView that displays a list of books.
 * It manages the data and creates the views for each item in the data set.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    // List of books
    private List<Book> books;

    /**
     * Constructor for the ListAdapter.
     * It initializes the list of books.
     */
    public ListAdapter() {
        this.books = UserBookList.getInstance().getUserBooks();
    }

    /**
     * Creates a new view holder.
     */
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(itemView);
    }

    /**
     * Binds the data to the view holder.
     */
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor());

        holder.expectedReturnDate.updateDate(book.getExpectedReturnDate().get(Calendar.YEAR), book.getExpectedReturnDate().get(Calendar.MONTH), book.getExpectedReturnDate().get(Calendar.DAY_OF_MONTH));

        // Set the DatePicker and Button for the expected return date
        holder.setReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = holder.expectedReturnDate.getDayOfMonth();
                int month = holder.expectedReturnDate.getMonth();
                int year = holder.expectedReturnDate.getYear();

                Calendar cal = Calendar.getInstance();
                cal.set(year, month, day);

//                Calendar date = calendar.getTime();

                // Set the expectedReturnDate of the book
                book.setExpectedReturnDate(cal);

                // Show a Toast message
                Toast.makeText(v.getContext(), "The book is set to be returned on: " + cal.getTime(), Toast.LENGTH_LONG).show();

                holder.expectedReturnDate.setClickable(false);
                holder.expectedReturnDate.updateDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

                // Notify the adapter that the data has changed
                notifyDataSetChanged();
            }
        });
    }

    /**
     * Returns the number of items in the data set.
     */
    @Override
    public int getItemCount() {
        return books.size();
    }

    /**
     * This class represents a view holder, which extends RecyclerView.ViewHolder.
     * A view holder describes an item view and metadata about its place within the RecyclerView.
     */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        final TextView bookTitle;
        final TextView bookAuthor;
        final DatePicker expectedReturnDate;
        final Button setReminderButton;

        /**
         * Constructor for the ListViewHolder.
         * It initializes the title, author, expected return date, and set reminder button of the book.
         */
        public ListViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthor = itemView.findViewById(R.id.book_author);
            expectedReturnDate = itemView.findViewById(R.id.expected_return_date);
            setReminderButton = itemView.findViewById(R.id.button_set_reminder);
        }
    }

    /**
     * Sets the list of books and notifies the RecyclerView that the data set has changed.
     */
    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    /**
     * Returns the list of books.
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Adds a book to the list and notifies the RecyclerView that the data set has changed.
     */
    public void addBook(Book book) {
        books.add(book);
        notifyDataSetChanged();
    }
}
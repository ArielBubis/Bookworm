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

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<Book> books;

    public ListAdapter() {
        this.books = UserBookList.getInstance().getUserBooks();;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor());
        // Set the DatePicker and Button here
        holder.setReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = holder.expectedReturnDate.getDayOfMonth();
                int month = holder.expectedReturnDate.getMonth();
                int year = holder.expectedReturnDate.getYear();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);

                Date date = calendar.getTime();

                // Set the expectedReturnDate of the book
                book.setExpectedReturnDate(date);

                // Show a Toast message
                Toast.makeText(v.getContext(), "The book is set to be returned on: " + date, Toast.LENGTH_LONG).show();

                holder.expectedReturnDate.setClickable(false);

                // Notify the adapter that the data has changed
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return books.size();
    }
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        final TextView bookTitle;
        final TextView bookAuthor;
        final DatePicker expectedReturnDate;
        final Button setReminderButton;

        public ListViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthor = itemView.findViewById(R.id.book_author);
            expectedReturnDate = itemView.findViewById(R.id.expected_return_date);
            setReminderButton = itemView.findViewById(R.id.button_set_reminder);
        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyDataSetChanged();
    }


}
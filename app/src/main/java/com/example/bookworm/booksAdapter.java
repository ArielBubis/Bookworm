package com.example.bookworm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {
    private ArrayList<Book> booksList;
    private Context context;

    public BooksAdapter(ArrayList<Book> booksList, Context context) {
        this.booksList = booksList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book currentBook = booksList.get(position);
        holder.titleTextView.setText(currentBook.getTitle());
        holder.authorTextView.setText(currentBook.getAuthor());
        holder.bookImageView.setImageResource(currentBook.getImageResource());
        // Set onClickListener for the "Add to list" button
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public ImageView bookImageView;
        public TextView titleTextView;
        public TextView authorTextView;
        public Button addToMyListButton;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookImageView = itemView.findViewById(R.id.bookImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
            addToMyListButton = itemView.findViewById(R.id.addToMyListButton);
        }
    }
}


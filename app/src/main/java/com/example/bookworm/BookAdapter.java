package com.example.bookworm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> books;

    public BookAdapter(List<Book> books, BrowseBooksActivity browseBooksActivity) {
        this.books = books;
    }

    public BookAdapter(ArrayList<Book> myList, MyListActivity myListActivity) {
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.image.setImageResource(book.getImageResource());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView author;

        public BookViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.book_image);
            title = itemView.findViewById(R.id.book_title);
            author = itemView.findViewById(R.id.book_author);
        }
    }
}

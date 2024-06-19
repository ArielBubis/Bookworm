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
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> books;
    private final Context context;

    public BookAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }
    public void updateDataset(List<Book> newBooksList) {
        books = newBooksList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public void onBindViewHolder(BookViewHolder bookViewHolder, int position) {
        Book book = books.get(position);
        bookViewHolder.setData(book);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item, viewGroup, false);
        return new BookViewHolder(itemView);
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        private final ImageView book_image;
        private final TextView book_title;
        private final TextView book_author;
        private final Button button_addBook;
        private Book b = null;

        public BookViewHolder(View v) {
            super(v);
            book_image = v.findViewById(R.id.book_image);
            book_title = v.findViewById(R.id.book_title);
            book_author = v.findViewById(R.id.book_author);
            button_addBook = v.findViewById(R.id.button_addBook);

            button_addBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle button click here
                }
            });
        }

        public void setData(Book b) {
            this.b = b;
            book_image.setImageResource(b.getImageResource());
            book_title.setText(b.getTitle());
            book_author.setText(b.getAuthor());
        }
    }
}

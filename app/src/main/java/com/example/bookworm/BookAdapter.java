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
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private static BookAdapter instance = null;
    private List<Book> allBooks; // list of all books
    private List<Book> displayedBooks; // list of currently displayed books

    public BookAdapter() {
        this.allBooks = createList(10);
        this.displayedBooks = new ArrayList<>(allBooks); // initially display all books
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public List<String> getAuthors() {
        List<String> authors = new ArrayList<>();
        for (Book book : allBooks) {
            authors.add(book.getAuthor());
        }
        return authors;
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


    public void updateDataset(List<Book> newBooksList) {
        displayedBooks = newBooksList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return displayedBooks.size();
    }

    @Override
    public void onBindViewHolder(BookViewHolder bookViewHolder, int position) {
        Book book = displayedBooks.get(position);
        bookViewHolder.setData(book);
    }


    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item, viewGroup, false);
        return new BookViewHolder(itemView);
    }

    public List<Book> getFullBooksList() {
        return createList(10);
    }

    public List<Book> filterBooksByAuthor(String selectedAuthor) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getAuthor().equals(selectedAuthor)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
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

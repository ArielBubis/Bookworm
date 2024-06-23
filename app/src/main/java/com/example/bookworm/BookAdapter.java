package com.example.bookworm;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is an adapter for the RecyclerView that displays books.
 * It manages the data and creates the views for each item in the data set.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private static BookAdapter instance = null;
    private List<Book> allBooks; // list of all books
    private List<Book> displayedBooks; // list of currently displayed books[


    /**
     * Constructor for the BookAdapter.
     * It initializes the list of all books and the list of displayed books.
     */

    public BookAdapter() {
        this.allBooks = createList(10);
        this.displayedBooks = new ArrayList<>(allBooks); // initially display all books
    }

    /**
     * Returns the list of all books.
     */
    public List<Book> getAllBooks() {
        return allBooks;
    }

    /**
     * Returns a set of all authors.
     */
    public Set<String> getAuthors() {
        Set<String> authors = new HashSet<>();
        for (Book book : allBooks) {
            authors.add(book.getAuthor());
        }
        return authors;
    }
    /**
     * Creates a list of books.
     */
    private List<Book> createList(int size) {
        List<Book> result = new ArrayList<>();
        result.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        result.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        result.add(new Book("To Kill a Mockingbird2", "Harper Lee"));
        result.add(new Book("To Kill a Mockingbird3", "Harper Lee"));
        result.add(new Book("To Kill a Mockingbird4", "Harper Lee"));
        result.add(new Book("1984", "George Orwell"));
        result.add(new Book("Animal Farm", "George Orwell"));
        result.add(new Book("Brave New World", "Aldous Huxley"));
        result.add(new Book("The Catcher in the Rye", "J.D. Salinger"));
        result.add(new Book("The Grapes of Wrath", "John Steinbeck"));
        return result;
    }


    /**
     * Updates the list of displayed books and notifies the RecyclerView that the data set has changed.
     */
    public void updateDataset(List<Book> newBooksList) {
        displayedBooks = newBooksList;
        notifyDataSetChanged();
    }

    /**
     * Returns the number of items in the data set.
     */
    @Override
    public int getItemCount() {
        return displayedBooks.size();
    }

    /**
     * Binds the data to the view holder.
     */
    @Override
    public void onBindViewHolder(BookViewHolder bookViewHolder, int position) {
        Book book = displayedBooks.get(position);
        bookViewHolder.book_image.setImageResource(book.getImageResource());
        bookViewHolder.book_title.setText(book.getTitle());
        bookViewHolder.book_author.setText(book.getAuthor());
        bookViewHolder.button_addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the ListAdapter instance
                UserBookList userBookList = UserBookList.getInstance();
                // Add the book to the userBookList
                userBookList.addUserBook(book);
//                Intent intent = new Intent(view.getContext(), MyListActivity.class);
//                view.getContext().startActivity(intent);
                Toast.makeText(view.getContext(), "The book '"+book.getTitle() +"' was added to your list", Toast.LENGTH_LONG).show();

            }
        });
    }


    /**
     * Creates a new view holder.
     */
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item, viewGroup, false);
        return new BookViewHolder(itemView);
    }

    /**
     * Returns the full list of books.
     */
    public List<Book> getFullBooksList() {
        return createList(10);
    }

    /**
     * Filters the books by author.
     */
    public List<Book> filterBooksByAuthor(String selectedAuthor) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getAuthor().equals(selectedAuthor)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    /**
     * This class represents a view holder, which extends RecyclerView.ViewHolder.
     * A view holder describes an item view and metadata about its place within the RecyclerView.
     */
    public static class BookViewHolder extends RecyclerView.ViewHolder {
        private final ImageView book_image;
        private final TextView book_title;
        private final TextView book_author;
        private final Button button_addBook;

        /**
         * Constructor for the BookViewHolder.
         * It initializes the image, title, author, and button of the book.
         */
        public BookViewHolder(View itemView) {
            super(itemView);
            book_image = itemView.findViewById(R.id.book_image);
            book_title = itemView.findViewById(R.id.book_title);
            book_author = itemView.findViewById(R.id.book_author);
            button_addBook = itemView.findViewById(R.id.button_addBook);
        }
    }
}

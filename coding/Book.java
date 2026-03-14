import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Book {
    String title;
    String author;

    public static void main(String[] args) {
        // Example list of books
        List<Book> books = Arrays.asList(
                new Book("Book1", "Author1"),
                new Book("Book2", "Author2"),
                new Book("Book3", "Author1"),
                new Book("Book4", "Author3"),
                new Book("Book5", "Author2")
        );


        // Grouping books by author using Stream API

        Map<String, List<Book>> booksByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
        System.out.println("booksByAuthor:" +booksByAuthor);

        Map<String, List<String>> bookToTitle = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor,
                        Collectors.mapping(Book::getTitle, Collectors.toList())
                ));
        System.out.println("BookToTitle: " + bookToTitle);

        //booksByAuthor:{Author3=[Book4], Author2=[Book2, Book5], Author1=[Book1, Book3]}
        //BookToTitle: {Author3=[Book4], Author2=[Book2, Book5], Author1=[Book1, Book3]}

        // Print the result
        /*booksByAuthor.forEach((author, bookList) -> {
            System.out.println("Author: " + author);
            bookList.forEach(book -> System.out.println("  " + book.getTitle()));
        });*/
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter method for author
    public String getAuthor() {
        return author;
    }

    // Getter method for title (optional)
    public String getTitle() {
        return title;
    }

    // Optional: Setter methods if you want to set values later (not used in this example)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    // Override toString() method to print meaningful information
    @Override
    public String toString() {
        return title;  // This will return the title when the book is printed
    }
}

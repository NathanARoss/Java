public class Book {
    private String name, ISBN;

    public Author getAuthor() {
        return author;
    }

    public Book(String name, String ISBN, Author author) {

        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
    }

    private Author author;
}

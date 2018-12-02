import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("The library contains the following books");

        List<Book> library = new ArrayList<>(20);
        fillLibrary(library, 20);

        Stream<Book> stream = library.stream();
        Stream<Book> oldAuthors = stream.filter((book) -> book.getAuthor().getAge() > 50).limit(10);
        Stream<String> uniqueSurnames = oldAuthors.map((book) -> book.getAuthor().getLastName().toUpperCase(Locale.US)).distinct();

        System.out.println("\nThe following is a list of authors older than 50 years.");
        uniqueSurnames.forEach(System.out::println);
    }

    private static void fillLibrary(List<Book> library, int count) {
        final String[] firstNames = {"Nathan", "Alisson", "Bryan", "Benson", "Phil", "Benito", "Brandon", "Henry", "Fredrick"};
        final String[] lastNames = {
                "Ross", "Leiva", "Travis", "Rodriguez", "Coleson", "Mussolini", "Valdes", "Cow", "Douglas",
                "Smith", "Roger", "Martinez", "Zhang", "Birmingham", "Barker", "Steers"
        };
        final String[] singularNouns = {"Lord", "Hero", "Sheep", "Fly", "Time", "Villain", "Aggressor", "Bully", "King"};
        final String[] pluralNouns = {"Lords", "Heroes", "Sheep", "Flies", "Times", "Villains"};

        Random random = new Random();
        for (int i = 0; i < count; ++i) {
            String first = firstNames[random.nextInt(firstNames.length)];
            String last = lastNames[random.nextInt(lastNames.length)];
            int age = random.nextInt(100) + 15;
            Author author = new Author(first, last, age);

            String singular = singularNouns[random.nextInt(singularNouns.length)];
            String plural = pluralNouns[random.nextInt(pluralNouns.length)];
            String title = singular + " of " + plural;

            int EAN_prefix = random.nextBoolean() ? 978 : 979;
            int registrationGroup = random.nextInt(100);
            int registrant = random.nextInt(100000);
            int publication = random.nextInt(100);
            int checkDigit = 0; //I don't feel like implementing a proper check digit
            String ISBN = String.format(Locale.US, "%d-%d-%d-%d-%d", EAN_prefix, registrationGroup, registrant, publication, checkDigit);

            Book book = new Book(title, ISBN, author);
            library.add(book);

            System.out.printf("%s (ISBN %s) by %s %s (age %d)%n", title, ISBN, first, last, age);
        }
    }
}
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new __________<>(); // TODO
    }

    public void addBook(__________ book) { // TODO: parameter type
        books.add(book);
    }

    public int countAvailable() {
        int count = 0;

        for (__________ book : books) { // TODO: fill in type
            if (!book.__________()) { // TODO: call the boolean getter
                __________; // TODO: increment count
            }
        }

        return count;
    }
}

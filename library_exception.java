 class LibraryBooks {

    interface Library {
        void displayBooks();
        void borrowBook(String title) throws BookNotAvailableException;
        void returnBook(String title) throws BookNotFoundException;
        void addBook(Book book) throws LibraryFullException;
    }

    static final int Maxbooks = 100;
    Book[] books;
    int numBooks;

    public class Book {
        String title;
        String author;
        boolean available;

        void initializeBook(String title, String author) {
            this.title = title;
            this.author = author;
            this.available = true;
        }
    }

    public LibraryBooks() {
        books = new Book[Maxbooks];
        numBooks = 0;
    }

    void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.title + " by " + book.author);
            }
        }
    }

    void borrowBook(String title) throws BookNotAvailableException {
        boolean found = false;
        for (Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title) && book.available) {
                System.out.println("Borrowed: " + book.title);
                book.available = false;
                found = true;
                break;
            }
        }
        if (!found) {
            throw new BookNotAvailableException("Book \"" + title + "\" is not available for borrowing.");
        }
    }

    void returnBook(String title) throws BookNotFoundException {
        boolean found = false;
        for (Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title) && !book.available) {
                System.out.println("You have returned: " + book.title);
                book.available = true;
                found = true;
                break;
            }
        }
        if (!found) {
            throw new BookNotFoundException("Book \"" + title + "\" was not found or already returned.");
        }
    }

    void addBook(Book book) throws LibraryFullException {
        if (numBooks < Maxbooks) {
            books[numBooks++] = book;
            System.out.println("Added: " + book.title);
        } else {
            throw new LibraryFullException("Library is full. Cannot add more books.");
        }
    }

    public static void main(String[] args) {
        LibraryBooks library = new LibraryBooks();

        try {
            library.addBook(library.new Book("Book1", "Author1"));
            library.addBook(library.new Book("Book2", "Author2"));
            library.addBook(library.new Book("Book3", "Author3"));
        } catch (LibraryFullException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            library.borrowBook("Book1");
            library.borrowBook("Book2");
            library.borrowBook("Book4"); 
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            library.returnBook("Book1");
            library.returnBook("Book3"); 
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        library.displayBooks();
    }
}

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class LibraryFullException extends Exception {
    public LibraryFullException(String message) {
        super(message);
    }
}


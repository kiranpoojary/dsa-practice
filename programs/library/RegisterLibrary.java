package programs.library;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    int quantity;

    public Book(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }

}

class LibrarySection {
    String sectionName;
    ArrayList<Book> books;

    public LibrarySection(String sectionName) {
        this.sectionName = sectionName;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        System.out.println("Books in " + sectionName + " Section:");
        for (Book book : books) {
            System.out.println(" - " + book.title);
        }
    }

}

class LibraryManagement {
    String libraryName;
    LibrarySection kidsSection;
    LibrarySection generalSection;

    public LibraryManagement(String libraryName) {
        this.libraryName = libraryName;
        this.kidsSection = new LibrarySection("Kids");
        this.generalSection = new LibrarySection("General");
    }

    public void addBookToSection(Book book, LibrarySection section) {
        section.addBook(book);
    }

    public void listAllBooks() {
        kidsSection.listBooks();
        generalSection.listBooks();
    }

    public void listAllSectionBooks(LibrarySection section) {
        section.listBooks();
    }

    public Book searchBook(LibrarySection section, String search) {
        for (Book book : section.books) {
            if (book.title.contains(search))
                return book;
        }
        return null;
    }

    public int checkStock(LibrarySection section, String search) {
        Book searchedBook = this.searchBook(section, search);
        if (searchedBook == null) {
            return -1;
        } else
            return searchedBook.quantity;
    }
}

public class RegisterLibrary {
    public static void main(String[] args) {
        LibraryManagement kiranLib = new LibraryManagement("Kiran's Library");
        kiranLib.addBookToSection(new Book("Tom and Jerry", 5), kiranLib.kidsSection);
        kiranLib.addBookToSection(new Book("Rich Dad, Poor Dad", 3), kiranLib.generalSection);
        // kiranLib.listAllSectionBooks(kiranLib.kidsSection);
        // kiranLib.listAllBooks();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        do {
            System.out.println("Choose option");
            System.out.println("0. Exit Lib");
            System.out.println("1. Show Menu again");
            System.out.println("2. Add Book");
            System.out.println("3. Search Book");
            System.out.println("4. Check Book Availability");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    System.out.println("Please select book section kids/gen");
                    String sectionName = sc.next();
                    if (sectionName.equals("kids")) {
                        System.out.println("Please enter book title");
                        String title = sc.next();
                        System.out.println("Please seenterlect book qty");
                        int qty = sc.nextInt();
                        Book newBook = new Book(title, qty);
                        kiranLib.addBookToSection(newBook, kiranLib.kidsSection);

                    } else if (sectionName.equals("gen")) {
                        //
                    } else {
                        System.out.println("Invalid sec");
                    }
                    break;
                case 3:
                    // search
                    System.out.println("Please select book section kids/gen");
                    String sectionName2 = sc.next();
                    LibrarySection sec = sectionName2.equals("kids") ? kiranLib.kidsSection : kiranLib.generalSection;
                    System.out.println("Please enter book title");
                    String title = sc.next();
                    Book searchedBook = kiranLib.searchBook(sec, title);
                    if (searchedBook != null) {
                        System.out.println("Book Title  :" + searchedBook.title);
                        System.out.println("Book qty    :" + searchedBook.quantity);
                    } else {
                        System.out.println("No book available with title  :" + title);
                    }
                    break;

                case 4:
                    System.out.println("qty");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        } while (choice != 0);
        System.out.println("**************** Thanks for visiting *******************");
    }
}

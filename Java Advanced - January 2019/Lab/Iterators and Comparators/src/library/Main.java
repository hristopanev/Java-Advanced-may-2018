package library;

public class Main {
    public static void main(String[] args) {


        Book book1 = new Book("War", 1999, "Peshov");
        Book book2 = new Book("Peace", 1999, "Pyrvanov");
        Book book3 = new Book("Bai Ganio", 1999, "Ivanov");


        Library library = new Library(book1, book2, book3);

        for (Book book : library) {
            System.out.println(book.getTitle());
        }
    }
}

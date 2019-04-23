package P02_book_Shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            String author = reader.readLine();
            String title = reader.readLine();
            double price = Double.parseDouble(reader.readLine());

            Book book = new Book(author, title, price);

            GoldenEditionBook goldenEditonBook = new GoldenEditionBook(author, title, price);

            Method[] goldenBookDeclaredMethods =
                    GoldenEditionBook.class.getDeclaredMethods();

            if (goldenBookDeclaredMethods.length < 1) {
                throw new IllegalArgumentException("Code duplication in GoldenEditionBook");
            }

            System.out.println(book);
            System.out.println(goldenEditonBook);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }
}

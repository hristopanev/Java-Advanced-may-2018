package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements  Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;

        this.authors = new ArrayList<>();

        if (authors.length == 0){
           // throw new IllegalArgumentException("No authors provided");
        }else {
            this.authors.addAll(Arrays.asList(authors));
        }


}

    @Override
    public int compareTo(Book o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}

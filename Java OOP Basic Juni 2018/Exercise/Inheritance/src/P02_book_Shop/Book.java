package P02_book_Shop;

public class Book {
    private String author;
    private String title;
    private double price;


    public Book(){}

    public Book(String author, String titel, double price){
        this.setAuthor(author);
        this.setTitle(titel);
        this.setPrice(price);
    }

    public String getAuthor(){
        return this.author;
    }
    private void setAuthor(String author){
        String[] authorTokens = author.split("\\s+");
        if (authorTokens.length == 2 && Character.isDigit(authorTokens[1].charAt(0))){
            throw new IllegalArgumentException("Author not valid!");
        }else {
            this.author = author;
        }
    }

    public String getTitle(){
        return this.title;
    }
    private void setTitle(String title){
        if (title.length() < 3){
            throw new IllegalArgumentException("Title not valid!");
        }else {
            this.title = title;
        }
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        if (price < 1){
            throw new IllegalArgumentException("Price not valid!");
        }else {
            this.price = price;
        }
    }

    @Override
    public String toString(){
    final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}

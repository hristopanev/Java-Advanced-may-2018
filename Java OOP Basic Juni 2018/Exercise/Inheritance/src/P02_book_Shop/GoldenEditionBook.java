package P02_book_Shop;

public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String author, String title, double price){
        super(author, title, price);
    }

    @Override
    public void setPrice(double price){
        double goldEditionBookPrice = price  + ((price * 30) / 100);
        super.setPrice(goldEditionBookPrice);
    }
}

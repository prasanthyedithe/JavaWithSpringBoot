package collections;

public class Book {

    String title;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
}

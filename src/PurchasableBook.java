public abstract class PurchasableBook extends Book {
    private double price;

    public PurchasableBook(String ISBN, String title, int publishingYear, double price) {
        super(ISBN, title, publishingYear);
        if (price > 0){
            this.price = price;
        }
        else{
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        }
        else{
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }

    public double getPrice() { return price; }
}

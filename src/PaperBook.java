public class PaperBook extends PurchasableBook {
    private int quantity;

    public PaperBook(String ISBN, String title, int publishingYear, double price, int quantity) {
        super(ISBN, title, publishingYear, price);
        if (quantity > 0){
            this.quantity = quantity;
        }
        else {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }

    public void addQuantity(int quantity) {
        if (quantity >= 0){
            this.quantity += quantity;
        }
        else {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
    }

    public void removeQuantity(int quantity) {
        if (quantity < 0){
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
        else if (this.quantity < quantity){
            throw new IllegalArgumentException("Not enough books in stock");
        }
        else {
            this.quantity -= quantity;
        }
    }

    public int getQuantity() { return quantity; }
}

import java.time.Year;
import java.util.ArrayList;

public class BookManager {
    private final ArrayList<Book> inventory;

    public BookManager() {
        inventory = new ArrayList<>();
    }

    public void addBook(String ISBN, String title, int publishingYear, double price, int quantity) {
        // Paper book
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                if (!(book instanceof PaperBook)){
                    throw new IllegalArgumentException("Book ISBN already exists and isn't PaperBook");
                }
                // Same paper books must have same title, publishing year, and price.
                if (book.getTitle().equals(title) && book.getPublishingYear() == publishingYear && ((PaperBook) book).getPrice() == price) {
                    ((PaperBook) book).addQuantity(quantity);
                }
                else{
                    throw new IllegalArgumentException("Paper book ISBN already exists but different information");
                }
                return;
            }
        }

        PaperBook pb = new PaperBook(ISBN, title, publishingYear, price, quantity);
        inventory.add(pb);
    }

    public void addBook(String ISBN, String title, int publishingYear, double price, String fileType){
        // Ebook
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
               if (!(book instanceof EBook)){
                   throw new IllegalArgumentException("Book ISBN already exists and isn't EBook");
               }
               // Same Ebooks must have same title and publishing year but not necessarily file type or price.
                if (((EBook) book).getFileType().equals(fileType)) {
                    return;
                }
                else if(book.getTitle().equals(title) && book.getPublishingYear() == publishingYear){
                    // Same book, different file type. Add a new instance.
                    break;
                }
                else{
                    throw new IllegalArgumentException("EBook ISBN already exists but different information");
                }
            }
        }

        EBook eb = new EBook(ISBN, title, publishingYear, price, fileType);
        inventory.add(eb);
    }

    public void addBook(String ISBN, String title, int publishingYear){
        // Demo Book
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                if (!(book instanceof DemoBook)){
                    throw new IllegalArgumentException("Book ISBN already exists and isn't DemoBook");
                }
                return;
            }
        }

        DemoBook db = new DemoBook(ISBN, title, publishingYear);
        inventory.add(db);
    }

    public void removeBook(int years){
        inventory.removeIf(book -> Year.now().getValue() > book.getPublishingYear() + years);
    }

    public double buyBook(String ISBN, int quantity, String address, String email){
        double amount = 0;
        boolean found = false;
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                if (book instanceof PaperBook pb){
                    pb.removeQuantity(quantity);
                    ShippingService.shipBook(ISBN, address);
                    return pb.getPrice() * quantity;
                }
                else if (book instanceof EBook eb){
                    // Assume when buying an e-book quantity doesn't matter but different
                    // fileTypes count towards different purchases.
                    // Also, Ebooks are not removed after being bought.
                    MailService.mailBook(ISBN, email, eb.getFileType());
                    found = true;
                    amount += eb.getPrice();
                }
                else if (book instanceof DemoBook){
                    throw new IllegalArgumentException("Demo books aren't for sale");
                }
                else {
                    throw new IllegalArgumentException("Illegal book type");
                }
            }
        }
        if (!found)
            throw new IllegalArgumentException("Book doesn't exist");

        return amount;
    }
}

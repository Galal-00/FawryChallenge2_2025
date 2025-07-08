public class EBook extends PurchasableBook {
    private final String fileType;

    public EBook(String ISBN, String title, int publishingYear, double price, String fileType) {
        super(ISBN, title, publishingYear, price);
        if (fileType.isEmpty())
            throw new IllegalArgumentException("File type cannot be empty");

        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}

import java.time.Year;

public abstract class Book {
    private final String ISBN;
    private final String title;
    private final int publishingYear;

    public Book(String ISBN, String title, int publishingYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishingYear = publishingYear;
        validate();
    }

    private void validate(){
        if (ISBN.isEmpty()){
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        if (title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (publishingYear < 1 || publishingYear > Year.now().getValue()){
            throw new IllegalArgumentException("Publishing year must be between 1 and this year: " + Year.now().getValue());
        }
    }

    public String getISBN() { return ISBN; }

    public String getTitle() { return title; }

    public int getPublishingYear() { return publishingYear; }
}

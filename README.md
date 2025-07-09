# Book Management System

A comprehensive Java-based book management system that supports different types of books including physical books, e-books, and demo books with full inventory management capabilities.

## Features

- **Multi-type Book Support**: Manage paper books, e-books, and demo books
- **Inventory Management**: Add, remove, and track book quantities
- **Purchase System**: Buy books with automatic shipping/mailing
- **Validation**: Robust input validation and error handling
- **Testing**: Comprehensive test cases for all functionality

## Project Structure

```
src/
├── Book.java              # Abstract base class for all books
├── PurchasableBook.java   # Abstract class for books that can be purchased
├── PaperBook.java         # Physical books with quantity management
├── EBook.java            # Digital books with file types
├── DemoBook.java         # Demo books (not for sale)
├── BookManager.java      # Main inventory management system
├── ShippingService.java  # Handles physical book shipping
├── MailService.java      # Handles e-book delivery
├── Testing.java          # Comprehensive test suite
└── Main.java            # Application entry point
```

## Book Types

### 1. Paper Books
- Physical books with inventory tracking
- Supports quantity management (add/remove stock)
- Requires shipping address for purchase
- Uses shipping service

### 2. E-Books
- Digital books with file type support (PDF, HTML, etc.)
- Multiple file formats per ISBN allowed
- Delivered via email
- Unlimited copies available
- Uses mail service

### 3. Demo Books
- Free preview versions
- Cannot be purchased

## Key Classes

### Book (Abstract Base Class)
- **Properties**: ISBN, title, publishing year
- **Validation**: Ensures ISBN and title are not empty, publishing year is valid
- **Methods**: Getters for all properties

### BookManager
- **Core functionality**: Add books, remove old books, handle purchases
- **Methods**:
  - `addBook(ISBN, title, year, price, quantity)` - Add paper book
  - `addBook(ISBN, title, year, price, fileType)` - Add e-book
  - `addBook(ISBN, title, year)` - Add demo book
  - `removeBook(years)` - Remove books older than specified years
  - `buyBook(ISBN, quantity, address, email)` - Purchase books

### Services
- **ShippingService**: Handles physical book delivery
- **MailService**: Handles e-book email delivery

## Usage Examples

### Adding Books
```java
BookManager manager = new BookManager();

// Add paper book
manager.addBook("ISBN0", "Book 0", 2017, 45.99, 10);

// Add e-book
manager.addBook("ISBN1", "Book 1", 2017, 35.99, "pdf");

// Add demo book
manager.addBook("ISBN2", "Book 2", 2017);
```

### Purchasing Books
```java
// Buy paper book
double cost = manager.buyBook("ISBN0", 2, "address", "user@example.com");

// Buy e-book
double cost = manager.buyBook("ISBN1", 1, "address", "user@example.com");
```

### Inventory Management
```java
// Remove books older than 5 years
manager.removeBook(5);
```

## Running the Application

### Prerequisites
- Java 11 or higher
- Java compiler (javac)

### Compilation
```bash
javac -d . src/*.java
```

### Running Tests
```bash
java Main
```

The application will run a comprehensive test suite with 12 test cases covering:
- Normal operations
- Input validation
- Error handling
- Edge cases
- Business logic validation

## Test Cases

The system includes 12 comprehensive test cases:

1. **Normal Operation** - Basic functionality test
2. **Invalid Paper Book** - Negative quantity validation
3. **Invalid E-Book** - Empty file type validation
4. **Invalid Demo Book** - Future year validation
5. **Duplicate Paper Book** - Quantity addition for existing books
6. **Multiple E-Book Formats** - Same ISBN, different file types
7. **Paper Book Conflicts** - Same ISBN with different data
8. **Book Removal** - No book can be removed
9. **Non-existent Book Purchase** - Error handling
10. **ISBN-Type Conflicts** - Different book types with same ISBN but different types
11. **Demo Book Purchase** - Validation that demo books aren't sellable
12. **Stock Management** - Attempt buying too much of the same book

## Error Handling

The system provides comprehensive error handling for:
- Invalid ISBN or title (empty strings)
- Invalid publishing years (past year validation)
- Invalid prices (must be positive)
- Invalid quantities (must be positive for paper books)
- Stock management (insufficient inventory)
- Business rule violations (demo books not for sale)

## Features Highlights

- **Type Safety**: Strong typing with inheritance hierarchy
- **Input Validation**: Comprehensive validation at object creation
- **Business Logic**: Proper handling of different book types
- **Service Integration**: Shipping and mailing services
- **Inventory Control**: Automatic stock management
- **Error Recovery**: Graceful error handling with meaningful messages
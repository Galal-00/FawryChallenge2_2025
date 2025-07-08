public class Testing {
    public static final Runnable[] tests = new Runnable[] {
            Testing::testcase1,
            Testing::testcase2,
            Testing::testcase3,
            Testing::testcase4,
            Testing::testcase5,
            Testing::testcase6,
            Testing::testcase7,
            Testing::testcase8,
            Testing::testcase9,
            Testing::testcase10,
            Testing::testcase11,
            Testing::testcase12,
    };

    private static void testcase1(){
        // Normal operation
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2010, 10.0, 3);
        bm.addBook("ISBN2", "Book2", 2014, 5.0, "pdf");
        bm.addBook("ISBN3", "Book3", 2019, 5.0, "pdf");
        bm.addBook("ISBN4", "Book4", 2020);
        bm.addBook("ISBN5", "Book5", 2024, 30.0, 4);

        bm.removeBook(10);
        double paidAmount = bm.buyBook("ISBN3", 1, "giza", "g@g.com");
        System.out.printf("Bought book with ISBN: %s, costed: %.2f EGP\n", "ISBN3", paidAmount);

        paidAmount = bm.buyBook("ISBN5", 2, "giza", "g@g.com");
        System.out.printf("Bought book with ISBN: %s, costed: %.2f EGP\n", "ISBN5", paidAmount);
    }

    private static void testcase2(){
        // Illegal paper book creation, illegal quantity
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 10.0, -3);
    }

    private static void testcase3(){
        // Illegal Ebook creation, illegal file type
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 10.0, "");
    }

    private static void testcase4(){
        // Illegal demo book creation, illegal year
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2027);
    }

    private static void testcase5(){
        // Add a paper book that already exists
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 10.0, 5);
        bm.addBook("ISBN1", "Book1", 2024, 10.0, 10);

        double paidAmount = bm.buyBook("ISBN1", 15, "giza", "g@g.com");
        System.out.printf("Bought book with ISBN: %s, costed: %.2f EGP\n", "ISBN1", paidAmount);
    }

    private static void testcase6(){
        // Add the same Ebook but different filetype
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 10.0, "pdf");
        bm.addBook("ISBN1", "Book1", 2024, 5.0, "html");

        double paidAmount = bm.buyBook("ISBN1", 1, "giza", "g@g.com");
        System.out.printf("Bought book with ISBN: %s, costed: %.2f EGP\n", "ISBN1", paidAmount);
    }

    private static void testcase7(){
        // Add a paper book that already exists but different data
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 10.0, 5);
        bm.addBook("ISBN1", "Book1", 2023, 10.0, 10);
    }

    private static void testcase8(){
        // No book can be removed
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 20.0, 5);
        bm.removeBook(10);
        double paidAmount = bm.buyBook("ISBN1", 3, "giza", "g@g.com");
        System.out.printf("Bought book with ISBN: %s, costed: %.2f EGP\n", "ISBN1", paidAmount);
    }

    private static void testcase9(){
        // Buy a book that doesn't exist
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 10.0, 5);
        bm.buyBook("ISBN2", 1, "giza", "g@g.com");
    }

    private static void testcase10(){
        // Add book that has same ISBN but different type
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 10.0, 5);
        bm.addBook("ISBN1", "Book1", 2023, 10.0, "html");
    }

    private static void testcase11(){
        // Attempt buying demo book
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024);
        bm.buyBook("ISBN1", 1, "giza", "g@g.com");
    }

    private static void testcase12(){
        // Attempt buying demo book
        BookManager bm = new BookManager();
        bm.addBook("ISBN1", "Book1", 2024, 10.0, 5);
        bm.buyBook("ISBN1", 1, "giza", "g@g.com");
        bm.buyBook("ISBN1", 5, "giza", "g@g.com");
    }
}

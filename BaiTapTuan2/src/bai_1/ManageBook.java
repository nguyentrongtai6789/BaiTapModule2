package bai_1;

public class ManageBook {
    Book proBook1 = new ProgrammingBook(101, "JavaBook", 10000, "James", "English", "Hay");
    Book proBook2 = new ProgrammingBook(102, "IntelBook", 20000, "Thomas", "Canada", "Good");
    Book proBook3 = new ProgrammingBook(103, "ScriptBook", 30000, "Ken", "VietNam", "Pro");
    Book proBook4 = new ProgrammingBook(104, "CodeBook", 40000, "Edison", "Japan", "Pain");
    Book proBook5 = new ProgrammingBook(105, "SourceBook", 50000, "Bob", "China", "Beijing");
    Book ficBook1 = new FictionBook(106, "Darius", 60000, "Naruto", "Viễn tưởng 1");
    Book ficBook2 = new FictionBook(107, "Darius", 70000, "Naruto", "Viễn tưởng 1");
    Book ficBook3 = new FictionBook(108, "Darius", 80000, "Naruto", "Viễn tưởng 2");
    Book ficBook4 = new FictionBook(109, "Darius", 90000, "Naruto", "Viễn tưởng 2");
    Book ficBook5 = new FictionBook(110, "Darius", 100000, "Naruto", "Viễn tưởng 3");
    Book[] books = {proBook1, proBook2, proBook3, proBook4, proBook5, ficBook1, ficBook2, ficBook3, ficBook4, ficBook5};

    public void getPriceOfAll() {
        double priceOfAll = 0;
        for (Book book : books) {
            priceOfAll += book.getPrice();
        }
        System.out.println("The total price is: " + priceOfAll);
    }

    public void displayAll() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void countPriceLessThan90000() {
        int count = 0;
        for (Book book : books) {
            if (book.getPrice() < 90000) {
                count++;
            }
        }
        System.out.println("The number of book have price less than 90000 is: " + count);
    }

    public void countFictionCategoryV1() {
        int count = 0;
        for (Book book : books) {
            if (book instanceof FictionBook newBook) {
                if (newBook.getCategory().equals("Viễn tưởng 1")) {
                    count++;
                }
            }
        }
        System.out.println("The number of fiction book have category 'Viễn tưởng 1' is: " + count);
    }


}

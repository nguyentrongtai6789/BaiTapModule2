package bai_1;

public class FictionBook extends Book{
    private String category;
    public FictionBook() {}

    public FictionBook(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public FictionBook(int bookCode, String name, double price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
    }
    @Override
    public String toString() {
        return "This is a fiction book" + ", category: " + category + ". Have " + super.toString();
    }
}

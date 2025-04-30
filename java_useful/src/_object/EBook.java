package _object;

public class EBook {

    private int bookTypeId;
    private String title;
    private String author;

    public EBook(int bookTypeId, String title, String author) {
        this.bookTypeId = bookTypeId;
        this.title = title;
        this.author = author;
    }

    // toString () 메서드 재정의

    @Override
    public String toString() {
        return super.toString();
    }

    // equals() 메서드 재정의

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    // hashCode() 메서드 재정의

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
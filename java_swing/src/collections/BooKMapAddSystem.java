package collections;

import java.util.HashMap;
import java.util.Scanner;

public class BooKMapAddSystem {

    private HashMap<String, Book> bookHashMap;

    public BooKMapAddSystem() {
        bookHashMap = new HashMap<>();
    }

    // 저장하는 메서드만 만들어 보세요 (자료구조에 저장하는 기능만 설계)
    public void saveBook(String name, String author) {
        bookHashMap.put(name, new Book(name, author));
    }

    // 콘솔창에 출력하는 메서드를 만들어 보세요 단, 책 제목과 저자를 모두 출력해야 합니다.
    public void printAllBook() {
        for (Book b : bookHashMap.values()) {
            System.out.println(b.toString());
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        BooKMapAddSystem booKMapAddSystem = new BooKMapAddSystem();
        booKMapAddSystem.saveBook("흥부와놀부", " 백은영");
        booKMapAddSystem.saveBook("거울 나라의 앨리스", "루이스 캐럴");

       booKMapAddSystem.printAllBook();
    }


} // end of class

// 데이터 타입 선언
class Book {
    String name;
    String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

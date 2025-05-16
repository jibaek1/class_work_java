package dto;

import lombok.*;

import javax.print.DocFlavor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String isbn;
    private boolean available;
}

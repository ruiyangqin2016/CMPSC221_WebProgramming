package psu.edu.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import psu.edu.bookstore.model.bookFile.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class book {

    private Long bookID;
    private String title;
    private Long ISBN;
    private String author;
    private DateTime datePublished;
    private String Genre;
    private Double price;

}

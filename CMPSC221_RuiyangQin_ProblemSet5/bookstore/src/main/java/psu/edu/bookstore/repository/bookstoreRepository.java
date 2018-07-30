package psu.edu.bookstore.repository;

import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.model.book;

import java.util.List;

public interface bookstoreRepository {

    List<book> findAllBooks();
    book searchBookByTitle(String title);
    book searchBookByAuthor(String author);
    book findBookByID(Long bookID);

    book addBook(Long bookID, String title, Long ISBN, String author, DateTime datePublished, String genre, Double price);

    book editBook(Long bookID, String title, Long ISBN, String author, DateTime datePublished, String genre, Double price);

    List<book> findAllBooksFiltered(String filterName);

    void deleteBook(Long bookID);

}

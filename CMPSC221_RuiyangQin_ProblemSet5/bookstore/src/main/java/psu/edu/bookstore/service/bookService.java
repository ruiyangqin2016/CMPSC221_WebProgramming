package psu.edu.bookstore.service;

import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.model.book;

import java.util.List;

public interface bookService {

    List<book> findAllBooks();

    book searchBookByTitle(String title);

    book searchBookByAuthor(String author);

    book findBookByID(Long bookID);

    List<book> findAllBooksFiltered(String filterName);

    book addBook(String bookID, String title, String ISBN, String author, String datePublished, String genre, String price);

    void deleteBook(Long bookID);

    book editBook(Long bookID, String title, Long ISBN, String author, DateTime datePublished, String genre, Double price);
}

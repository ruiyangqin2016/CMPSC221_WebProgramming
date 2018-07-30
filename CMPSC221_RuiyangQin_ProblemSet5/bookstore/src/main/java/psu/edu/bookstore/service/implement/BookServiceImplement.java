package psu.edu.bookstore.service.implement;

import psu.edu.bookstore.model.book;
import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.repository.bookstoreRepository;
import psu.edu.bookstore.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplement implements bookService {

    @Autowired
    private bookstoreRepository bookstoreRepository;

    @Override
    public List<book> findAllBooks(){
        return bookstoreRepository.findAllBooks();
    }

/*
    @Override
    public book searchBookByTitle(String title){
        return bookstoreRepository.searchBookByTitle(title);
    }

    @Override
    public book searchBookByAuthor(String author){
        return bookstoreRepository.searchBookByAuthor(author);
    }
*/



    @Override
    public List<book> findAllBooksFiltered(String filterName){
        return bookstoreRepository.findAllBooksFiltered(filterName);
    }

    @Override
    public book addBook(String bookID, String title, String ISBN, String author, String datePublished, String genre, String price){
        DateTime a;
        String arrDate[]  = datePublished.split("/");
        a = new DateTime(Integer.parseInt(arrDate[0]),Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[2]));
        return bookstoreRepository.addBook(Long.valueOf(bookID),title, Long.valueOf(ISBN), author, a, genre, Double.parseDouble(price));
    }

    @Override
    public book editBook(Long bookID, String title, Long ISBN, String author, DateTime datePublished, String genre, Double price){
        return bookstoreRepository.editBook(bookID, title, ISBN, author, datePublished, genre, price);
    }

    @Override
    public void deleteBook(Long bookID){
        bookstoreRepository.deleteBook(bookID);
    }

    @Override
    public book findBookByID(Long bookID) {
        return bookstoreRepository.findBookByID(bookID);
    }

    @Override
    public book searchBookByTitle(String title){return bookstoreRepository.searchBookByTitle(title);}

    @Override
    public book searchBookByAuthor(String author){return bookstoreRepository.searchBookByAuthor(author);}
}

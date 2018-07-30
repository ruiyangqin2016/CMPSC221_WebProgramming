package psu.edu.bookstore.repository.implement;

import psu.edu.bookstore.model.book;
import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.repository.bookstoreRepository;
import com.google.common.collect.MoreCollectors;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class bookstoreRepositoryImplement implements bookstoreRepository {

    private List<book> books = new ArrayList<>();

    @Override
    public List<book> findAllBooks(){return books;}

    @Override
    public book searchBookByTitle(String title){
        return books.stream()
                .filter(book ->book.getTitle().equals(title))
                .collect(MoreCollectors.onlyElement());
    }

    @Override
    public book searchBookByAuthor(String author){
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(MoreCollectors.onlyElement());
    }

    @Override
    public book findBookByID(Long bookID) {
        return books.stream()
                .filter(book -> book.getBookID().equals(bookID))
                .collect(MoreCollectors.onlyElement());
    }

    @Override
    public book addBook(Long bookID, String title, Long ISBN, String author, DateTime datePublished, String genre, Double price){
//        DateTime a;
//        String arrDate[]  = datePublished.split("/");
//        a = new DateTime(Integer.parseInt(arrDate[0]),Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[2]));
//        String genreArr[]={"fiction", "satire", "drama", "action", "adventure", "romance",
//                "mystery", "horror", "travel", "children", "religion", "spirituality",
//                "science","history", "math", "anthology", "poetry", "comics", "art",
//                 "journal", "series", "biography", "autobiography", "fantasy"};
//        Genre genreEnumArr[]={Genre.fiction,Genre.satire,Genre.drama,Genre.action,Genre.adventure,Genre.romance,
//                Genre.mystery, Genre.horror,Genre.travel,Genre.children,Genre.religion,Genre.spirituality,
//                Genre.science, Genre.history,Genre.math,Genre.anthology,Genre.poetry,Genre.comics,Genre.art,
//                Genre.journal, Genre.series, Genre.biography, Genre.autobiography, Genre.fantasy};
//        Genre b = Genre.valueOf("wrong");
//        for(int i = 0; i < genreArr.length; i ++){
//            if(genreArr[i].equals(genreEnumArr[i].toString())){
//                b = genreEnumArr[i];
//            }
//        }
        book toAdd = new book(bookID, title, ISBN, author, datePublished, genre, price);
        books.add(toAdd);
        return toAdd;
    }

    @Override
    public book editBook(Long bookID, String title, Long ISBN, String author, DateTime datePublished, String genre, Double price){
        book newBook = null;
        for(book b:books){
            if(b.getBookID().equals(bookID)){
                newBook = b;
            }
        }

        if(newBook != null){
            newBook.setTitle(title);
            newBook.setISBN(ISBN);
            newBook.setAuthor(author);
            newBook.setDatePublished(datePublished);
            newBook.setGenre(genre);
            newBook.setPrice(price);
        }

        return newBook;
    }

    @Override
    public List<book> findAllBooksFiltered(String filterName){
        boolean title = false;
        for(int i = 0; i < books.size(); i++){
            if(filterName.equals(books.get(i).getTitle())){
                title = true;
            }
        }
        if(title){
            return books.stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(filterName.toLowerCase()))
                    .collect(Collectors.toList());
        }else{
            return books.stream()
                    .filter(book -> book.getAuthor().toLowerCase().contains(filterName.toLowerCase()))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void deleteBook(Long bookID){
        book deleteBook = null;
        for(book b: books){
            if(b.getBookID().equals(bookID)){
                deleteBook = b;
            }
        }

        if(deleteBook != null){
            books.remove(deleteBook);
        }
    }
}

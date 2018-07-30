package psu.edu.bookstore.controller;

import psu.edu.bookstore.model.book;
import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.service.bookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private bookService bookService;

    @GetMapping(value = "/")
    public String indexPage(Model model){
        List<book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList",bookList);
        return "index";
    }

    @PostMapping(value = "/")
    public String filteredIndexPage(@RequestParam String filterName, Model model){
        List<book> bookList = bookService.findAllBooksFiltered(filterName);
        model.addAttribute("bookList",bookList);
        return "index";
    }

    @GetMapping(value = "/admin/bookstore/view")
    public String addViewPage(Model model){
        List<book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList",bookList);
        return "view";
    }

    @PostMapping(value = "/admin/bookstore/view")
    public String addViewForm(@RequestParam String filterName, Model model){
        List<book> bookList = bookService.findAllBooksFiltered(filterName);
        model.addAttribute("bookList",bookList);
        return "redirect:/";
    }

    @GetMapping(value = "/admin/bookstore/add")
    public String addBookPage(){
        return "addbook";
    }

    @PostMapping(value = "/admin/bookstore/add")
    public String addBookForm(@RequestParam String bookID, @RequestParam String title, @RequestParam String ISBN, @RequestParam String author, @RequestParam String datePublished, @RequestParam String Genre, @RequestParam String price){

        bookService.addBook(bookID,title, ISBN, author, datePublished, Genre, price);
        return "redirect:/";
    }

    @GetMapping(value = "/admin/bookstore/edit/{bookID}")
    public String editBookPage(@PathVariable(value = "bookID") Long bookID, Model model){
        if(bookID <=0||bookID==null){
            throw new IllegalStateException("book ID is required!");
        }
        book book = bookService.findBookByID(bookID);
        if(book != null){
            model.addAttribute("bookID",book.getBookID());
            model.addAttribute("title",book.getTitle());
            model.addAttribute("ISBN",book.getISBN());
            model.addAttribute("author",book.getAuthor());
            model.addAttribute("datePublished",book.getDatePublished().toString());
            model.addAttribute("Genre",book.getGenre());
            model.addAttribute("price",book.getPrice());
        }
        return "editbook";
    }

    @PostMapping(value = "/admin/bookstore/edit")
    public String editBookPage(@RequestParam Long bookID, @RequestParam String title, @RequestParam Long ISBN, @RequestParam String author, @RequestParam String datePublished, @RequestParam String Genre, @RequestParam Double price){
         if(bookID==null||bookID<=0){
             throw new IllegalStateException("book ID is required!");
         }

        DateTime a;
        String arrDate[]  = datePublished.split("/");
        a = new DateTime(Integer.parseInt(arrDate[0]),Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[2]));
         book book = bookService.editBook(bookID, title, ISBN, author, a, Genre, price);
         log.debug("Book edit successful with ID " + book.getBookID());
         return "redirect:/";
    }

    @GetMapping(value = "/admin/bookstore/delete/{bookID}")
    public String deleteBook(@PathVariable(value = "bookID") Long bookID){
        if(bookID==null||bookID<=0){
            throw new IllegalStateException("book ID is required!");
        }
        bookService.deleteBook(bookID);
        return "redirect:/";
    }
}

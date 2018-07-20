package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.MemoryBookService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookDao;

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/")
    public List<Book> getbooks() {
        return bookDao.getList();
    }

    @GetMapping("/{id}")
    public Book getbooks(@PathVariable long id) {
        Book book = bookDao.getList().stream().filter(b -> b.getId() == 1).findFirst().get();
        return book;
    }

    @PostMapping("/")
    public void appendBook(@RequestBody Book book) {
        bookDao.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
        bookDao.deleteBook(id);
    }
}
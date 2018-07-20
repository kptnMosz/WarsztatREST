package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.app.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {
    private List<Book> list;
    private long lastId=0;

    public MemoryBookService() {
        list = new ArrayList<>();
        addBook(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        addBook(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        addBook(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> getList() {
        return list;
    }

    @Override
    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public void addBook(Book book) {
        book.setId(++this.lastId);
        list.add(book);
    }

    @Override
    public void deleteBook(long id) {
        Book book = list.stream().filter(b-> b.getId()==id).findAny().get();
        if(book==null){
            return;
        }
        list.remove(book);
    }


}

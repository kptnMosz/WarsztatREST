package pl.coderslab.service;

import pl.coderslab.app.Book;

import java.util.List;

public interface BookService {
    public List<Book> getList();

    public void setList(List<Book> list);

    public void addBook(Book book);

    public void deleteBook(long id);

}

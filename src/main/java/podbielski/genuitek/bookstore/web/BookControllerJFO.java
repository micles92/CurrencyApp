package podbielski.genuitek.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.repository.BookRepository;
import podbielski.genuitek.bookstore.web.datatable.BookTableModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.Random;

/**
 * Copyright (C) 2016 , Sygnity SA. Wszystkie prawa zastrzeżone.
 *
 * @author <a href="mailto:mpodbielski@sygnity.pl">Mateusz Podbielski</a>
 * @version 1.0.0
 * @since 09/05/16
 * <p>
 * Historia zmian: <br/>
 * 09/05/16 - mpodbielski - utworzenie klasy
 */
@ManagedBean
@ViewScoped
@Component
public class BookControllerJFO extends BookController {


    public List<Book> getAllOlderThanYear() {
        return bookService.findAllOlderThanYear(this.year);
    }


    public void filterBooksByYear() {
        this.bookTableModel = new BookTableModel(bookService.findAllOlderThanYear(this.year));
    }

    public void getAllBooks() {
        this.bookTableModel = new BookTableModel(bookService.findAllBooks());
    }
}
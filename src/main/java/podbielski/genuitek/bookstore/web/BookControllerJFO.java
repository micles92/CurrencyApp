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

    @Autowired
    BookRepository bookRepository;

    //TODO JFO - implemnetacja i wycigniecie zmiennej z widoku
    private List<Book> getAllOlderThanYear() {
        return bookService.findAllOlderThanYear(this.year);
    }

    public void filterBooksByYear() {
        prepareBooks(10);
        this.bookTableModel = new BookTableModel(this.getAllOlderThanYear());

        //TODO JFO Implementacja: bookDataModel musi zostac ustawiony na to co zwroci ≥getAllOlderThanYear< czyli na ksiazki przefiltrowane po roku
    }


    private void prepareBooks(int count) {
        Random rand = new Random();
        int min = 1900;
        int max = 2016;

        for (int i = 0; i < count; i++) {
            Book book = new Book("Book title " + i, rand.nextInt((max - min) + 1) + min);
            bookRepository.save(book);
        }
    }
}

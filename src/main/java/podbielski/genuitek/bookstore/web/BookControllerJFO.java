package podbielski.genuitek.bookstore.web;

import org.springframework.stereotype.Component;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.web.datatable.BookTableModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

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


    //TODO JFO - implemnetacja i wycigniecie zmiennej z widoku
    public List<Book> getAllOlderThanYear(){
//        return bookService.findAllOlder... ;
        return null;
    }

    public void filterBooksByYear(){
        //TODO JFO Implementacja: bookDataModel musi zostac ustawiony na to co zwroci ≥getAllOlderThanYear< czyli na ksiazki przefiltrowane po roku
    }
}

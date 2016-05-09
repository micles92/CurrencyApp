package podbielski.genuitek.bookstore.web;

import org.springframework.stereotype.Component;
import podbielski.genuitek.bookstore.domain.Book;

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


    //TODO JFO - implemnetacja i powiązanie z widokiem
    public List<Book> getAllOlderThanYear(){
//        if(this.getYear()!=0) {
//            return bookService.findAllOlderThanYear(this.getYear());
//        }
//        return this.getBooks();
        return null;
    }
}

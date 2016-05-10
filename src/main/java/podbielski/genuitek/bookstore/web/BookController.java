/**
 *
 */
package podbielski.genuitek.bookstore.web;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import podbielski.genuitek.bookstore.domain.Author;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.repository.BookRepository;
import podbielski.genuitek.bookstore.service.AuthorService;
import podbielski.genuitek.bookstore.service.BookService;
import podbielski.genuitek.bookstore.web.datatable.BookTableModel;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Random;


/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */

public class BookController {

    @Autowired
    protected BookService bookService;
    @Autowired
    protected AuthorService authorService;
    @Autowired
    protected BookRepository bookRepository;

    protected BookTableModel bookTableModel;
    protected List<Author> authors;
    protected Book selectedBook;

    //zmienna ustawiająca warunek od roku
    protected int year;

    // Konstruktor domyslny
    public BookController() {
    }

    // Inicjalizacja bean'a
    @PostConstruct
    public void initBean() {
        // prepareBooks(8);
        // Poczatkowa wartosc bookTableModel ustawiona na wszystkie ksiazki
        this.bookTableModel = new BookTableModel(bookService.findAllBooks());
    }

    public List<Author> getAuthors() {
        return authorService.findByBook(getSelectedBook());
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    public BookTableModel getBookTableModel() {
        return bookTableModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Methods
   /*
    *  Gets the selected book's full text (title + year) and appends related
    *  authors' full names
    */
    public String getSelectionText() {
        StringBuilder sb = null;
        if (getSelectedBook() != null) {
            sb = new StringBuilder(getSelectedBook().toString());
            for (Author author : authorService.findByBook(getSelectedBook())) {
                sb.append(author.toString());
            }
        }
        return (null == sb) ? "" : sb.toString();
    }

    public void showInGrowl() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Book Details", getSelectionText()));
    }

    public void onRowSelect(SelectEvent event) {
        authors = authorService.findByBook(getSelectedBook());
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


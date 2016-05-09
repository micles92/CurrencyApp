/**
 * 
 */
package podbielski.genuitek.bookstore.web;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import podbielski.genuitek.bookstore.domain.Author;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.service.AuthorService;
import podbielski.genuitek.bookstore.service.BookService;
import podbielski.genuitek.bookstore.web.datatable.BookTableModel;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;


/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */


public class BookController {

	@Autowired protected BookService bookService;

    @Autowired protected AuthorService authorService;

    protected List<Book> books;

    protected BookTableModel bookTableModel;

    protected List<Author> authors;

    protected Book selectedBook;

	//zmienna ustawiająca warunek od roku
    protected int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


    public BookController() {
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
        return new BookTableModel(bookService.findAllBooks());
    }

    //Methods
   /*
    *  Gets the selected book's full text (title + year) and appends related
    *  authors' full names
    */
    public String getSelectionText(){
        StringBuilder sb = null;
        if(getSelectedBook() != null) {
            sb = new StringBuilder(getSelectedBook().toString());
            for (Author author : authorService.findByBook(getSelectedBook())){
                sb.append( author.toString() );
            }
        }
        return (null == sb)? "" : sb.toString();
    }

    public void showInGrowl(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage( null, new FacesMessage( "Book Details", getSelectionText() ));
    }

    public void onRowSelect(SelectEvent event) {
        authors = authorService.findByBook(getSelectedBook());
    }

}

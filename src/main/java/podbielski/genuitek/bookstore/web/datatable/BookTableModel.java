package podbielski.genuitek.bookstore.web.datatable;

import org.primefaces.model.SelectableDataModel;
import podbielski.genuitek.bookstore.domain.Book;


import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */
public class BookTableModel extends ListDataModel<Book> implements SelectableDataModel<Book> {

    public BookTableModel() {
    }

    public BookTableModel(List<Book> list) {
        super(list);
    }

    @Override
    public Object getRowKey(Book book) {
        return  book.getId();
    }

    @Override
    public Book getRowData(String s) {
        List<Book> books = (List<Book>) getWrappedData();

        for(Book book : books) {
            if(book.getId() == new Long(s))
                return book;
        }
        return null;
    }
}

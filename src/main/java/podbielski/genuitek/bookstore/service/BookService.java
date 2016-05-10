/**
 *
 */
package podbielski.genuitek.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.repository.BookRepository;

import java.util.List;

/**
 * @author mateusz.podbielski@genuitek.com
 * @date 7/10/13
 */

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findAllOlderThanYear(int year) {
        return bookRepository.findOlderThanYear(year);
    }
}

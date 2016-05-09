/**
 * 
 */
package podbielski.genuitek.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mateusz.podbielski@genuitek.com
 * @date 7/10/13
 */

@Service
@Transactional
public class BookService
{
	@Autowired private BookRepository bookRepository;

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	//TODO JFO implmentacja
	public List<Book> findAllOlderThanYear(int year) {
//		//FIXME JFO Zła implementacja - nalezy skorzystac z repository i __NIE_ITEROWAC__ obiektow
//		List<Book> books = new ArrayList<Book>();
//		for(Book book : this.bookRepository.findAll()){
//			if(book.getYear() < year){
//				books.add(book);
//			}
//		}
		return null;
	}
}

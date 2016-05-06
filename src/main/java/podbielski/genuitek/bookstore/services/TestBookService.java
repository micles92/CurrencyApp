/**
 * 
 */
package podbielski.genuitek.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.repositories.BookRepository;


import java.util.List;

/**
 * @author mateusz.podbielski@genuitek.com
 * @date 7/10/13
 */

@Service(value = "testBookService")
@Transactional
public class TestBookService
{
	@Autowired private BookRepository bookRepository;


	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	//TODO implmentacja metody filtrujacej po roku


	
}

package podbielski.genuitek.bookstore.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.services.BookService;

import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-test.xml")
public class BookServiceTest
{
	@Autowired
	private BookService bookService;
	
	@Test
	public void testFindAllusers() {
		List<Book> books = bookService.findAllBooks();
		Assert.assertNotNull(books);
		for (Book book : books) {
			System.err.println(book.toString());
		}
	}
}

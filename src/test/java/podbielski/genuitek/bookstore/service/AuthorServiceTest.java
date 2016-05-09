package podbielski.genuitek.bookstore.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import podbielski.genuitek.bookstore.domain.Author;
import podbielski.genuitek.bookstore.domain.Book;

import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-test.xml")
public class AuthorServiceTest
{
	@Autowired
	private AuthorService authorService;
	
    @Test
	public void testFindByBook() {
        Book book = new Book();
        book.setId(2);

		List<Author> authors = authorService.findByBook(book);
		Assert.assertNotNull(authors);
		for (Author author : authors) {
			System.err.println(author.toString());
		}
	}
}

package podbielski.genuitek.bookstore.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import podbielski.genuitek.bookstore.domain.Book;

import java.util.List;
import java.util.Random;


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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-test.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class BookRepostioryTest {

    private EmbeddedDatabase db;

    @Autowired
    private BookRepository bookRepository;

    //TODO JFO
    @Test
    public void testFindAllOrderedByYear() {
        prepareBooks(3);
        List<Book> result = bookRepository.findAllOrderedByYear();
        Assert.assertNotNull(result);
        Assert.assertEquals("find all ordered by year", 3, result.size());

    }

    @Test
    public void testFindAllOrderedByTitle() {
        prepareBooks(3);
        List<Book> books = bookRepository.findAllOrderedByTitle();
        Assert.assertNotNull(books);
    }

    //FIXME JFO
    // @Test
    public void testFindAllOlderThanYear() {
        prepareBooks(3);
        List<Book> books = bookRepository.findOlderThanYear(2004);
        Assert.assertNotNull(books);
    }

    @Test
    public void testFindByTitle() {
        prepareBooks(3);
        List<Book> result = bookRepository.findLatestByTitleWithJPQLQuery("3");
        Assert.assertNotNull(result);
        Assert.assertEquals("find by title", 1, result.size());

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

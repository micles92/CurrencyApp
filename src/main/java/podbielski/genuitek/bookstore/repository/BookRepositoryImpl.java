package podbielski.genuitek.bookstore.repository;

import podbielski.genuitek.bookstore.domain.Author;
import podbielski.genuitek.bookstore.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by jfonferko on 2016-05-09.
 */
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findOlderThanYear(int year) {
        return null;
    }

    @Override
    public List<Book> findLatestByTitleWithJPQLQuery(String title) {
       return null;
    }

    @Override
    public List<Book> findAllOrderedByYear() {
       return null;
    }

    @Override
    public List<Book> findAllOrderedByTitle() {
        return null;
    }
}
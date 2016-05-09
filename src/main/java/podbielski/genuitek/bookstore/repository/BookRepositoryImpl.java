package podbielski.genuitek.bookstore.repository;

import podbielski.genuitek.bookstore.domain.Author;
import podbielski.genuitek.bookstore.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by jfonferko on 2016-05-09.
 */
public abstract class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //TODO JFO A jak do tego ma sie lambda? Implementacja podstawowych zapytan moze byc realizowana bez szczegolnej implmentacji
    //http://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/repositories.html#repositories.query-methods.query-creation

    @Override
    public List<Book> findOlderThanYear(int year) {
        TypedQuery<Book> query =
                entityManager.createNamedQuery("Book.findOlderThanYear", Book.class);
        query.setParameter("book", year);
        return query.getResultList();
    }

    @Override
    public List<Book> findAllOrderedByYear() {
        TypedQuery<Book> query =
                entityManager.createNamedQuery("Book.findAllOrderedByYear", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> findAllOrderedByTitle() {
        TypedQuery<Book> query = entityManager.createNamedQuery("Book.findAllOrderedByTitle", Book.class);
        return query.getResultList();
    }

}

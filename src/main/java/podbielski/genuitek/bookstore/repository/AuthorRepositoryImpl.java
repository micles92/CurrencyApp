package podbielski.genuitek.bookstore.repository;



import org.springframework.stereotype.Repository;
import podbielski.genuitek.bookstore.domain.Author;
import podbielski.genuitek.bookstore.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */

public abstract class AuthorRepositoryImpl implements AuthorRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> findByBook(Book book){
        TypedQuery<Author> query =
                entityManager.createNamedQuery("Author.findByBookId", Author.class);
        query.setParameter("book", book.getId());
        return query.getResultList();
    }

}

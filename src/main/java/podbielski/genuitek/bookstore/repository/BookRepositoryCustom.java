/**
 *
 */
package podbielski.genuitek.bookstore.repository;


import org.springframework.stereotype.Repository;
import podbielski.genuitek.bookstore.domain.Book;

import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */
@Repository
public interface BookRepositoryCustom {

    List<Book> findOlderThanYear(int year);

    List<Book> findAllOrderedByYear();

    List<Book> findAllOrderedByTitle();

    List<Book> findLatestByTitleWithJPQLQuery(String title);
}

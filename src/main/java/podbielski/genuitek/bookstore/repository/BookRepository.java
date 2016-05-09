/**
 *
 */
package podbielski.genuitek.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import podbielski.genuitek.bookstore.domain.Book;

import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findOlderThanYear(int year);

    List<Book> findAllOrderedByYear();

    List<Book> findAllOrderedByTitle();
}

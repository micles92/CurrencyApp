/**
 * 
 */
package podbielski.genuitek.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import podbielski.genuitek.bookstore.domain.Author;
import podbielski.genuitek.bookstore.domain.Book;


import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>
{
    List<Author> findByBook(Book book);
}

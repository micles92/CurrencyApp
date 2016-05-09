/**
 * 
 */
package podbielski.genuitek.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import podbielski.genuitek.bookstore.domain.Author;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.repository.AuthorRepository;


import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */

@Service
@Transactional
public class AuthorService
{
	@Autowired private AuthorRepository authorRepository;

    public List<Author> findByBook(Book book){
        return authorRepository.findByBook(book);
//        return null;
    }


}

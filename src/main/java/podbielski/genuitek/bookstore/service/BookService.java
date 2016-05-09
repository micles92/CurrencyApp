/**
 * 
 */
package podbielski.genuitek.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mateusz.podbielski@genuitek.com
 * @date 7/10/13
 */

@Service
@Transactional
public class BookService
{
	@Autowired private BookRepository bookRepository;

	//Mapa zawierajaca mape ksiazek w zaleznosci od roku wydania
	private static Map<Integer, List<Book>> booksMap;

	//Mapa powinna byc zainicjowana w konstruktorze
	//Moze to byc lista 3 pozycji dla kazdego roku - liczba lat - moze byc tez 3


	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	
	//TODO JFO implmentacja
	public List<Book> findAllOlderThanYear(int year) {
		
		//1. zwroc liste ksiazek z mapy bookMap gdzie:
		// year >= bookMap.year

		//FIXME JFO Zła implementacja - nalezy uzyc repository
		List<Book> books = new ArrayList<Book>();
		for(Book book : this.bookRepository.findAll()){
			if(book.getYear() < year){
				books.add(book);
			}
		}

		return null;			
	}



	
}

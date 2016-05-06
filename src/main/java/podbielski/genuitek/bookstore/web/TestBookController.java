/**
 * 
 */
package podbielski.genuitek.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import podbielski.genuitek.bookstore.domain.Book;
import podbielski.genuitek.bookstore.services.TestBookService;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;


/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */

@ManagedBean(name = "testBookController")
@ViewScoped
@Component(value = "testBookController")
public class TestBookController extends BookController {


	@Autowired
	private TestBookService testBookService;

	//TODO implemnetacja metody
	public List<Book> getAllOlderThanYearKSI(){
		if(this.getYear()!=0) {
			return testBookService.findAllOlderThanYear(this.getYear());
		}
		return this.getBooks();
	}




}

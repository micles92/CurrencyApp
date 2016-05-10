package podbielski.genuitek.bookstore.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */
@Entity
@Table(name = "books")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Book.findOlderThanYear",
                query = "SELECT b FROM Book b WHERE b.year <= :year ORDER BY b.year"),
        @NamedQuery(name = "Book.findAllOrderedByYear", query = "SELECT b FROM Book b ORDER BY b.year"),
        @NamedQuery(name = "Book.findAllOrderedByTitle", query = "SELECT b FROM Book b ORDER BY b.title ASC"),
        @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title like lower(concat('%',:title,'%')) ")

})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "year")
    private int year;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Author> authors;

    public Book() {
    }

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String toString() {
        return title + ", " + year + ": ";
    }


}

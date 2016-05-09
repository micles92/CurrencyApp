package podbielski.genuitek.bookstore.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mateusz.podbielski@fgenuitek.com
 * @date 7/10/13
 */
@Entity
@Table(name = "authors")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
        @NamedQuery(name = "Author.findByBookId", query = "SELECT a FROM Author a WHERE a.book = :book")
})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 3, max = 15)
    @Column(name = "firstname")
    private String firstname;

    @NotNull
    @Size(min = 6, max = 20)
    @Column(name = "lastname")
    private String lastname;

    @ManyToOne
    private Book book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String toString(){
        return firstname + " " + lastname;
    }

    public String getFullname(){
        return firstname + " " + lastname + " ";
    }


}

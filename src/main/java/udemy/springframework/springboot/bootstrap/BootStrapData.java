package udemy.springframework.springboot.bootstrap;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.springframework.springboot.domain.Author;
import udemy.springframework.springboot.domain.Book;
import udemy.springframework.springboot.repositories.AuthorRepository;
import udemy.springframework.springboot.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12341123");
        eric.getBooks().add(ddd);
        ddd.getAutor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author ("Rod", "Johnson");
        Book noEJB = new Book ("J2EE Development without EJB", "3487934713");
        rod.getBooks().add(noEJB);
        noEJB.getAutor().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println ("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}

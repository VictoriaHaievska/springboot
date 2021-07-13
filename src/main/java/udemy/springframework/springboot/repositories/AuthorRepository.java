package udemy.springframework.springboot.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.springframework.springboot.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

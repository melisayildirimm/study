package yte.intern.spring_data;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.border.AbstractBorder;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    Book findByTitle(String title);

    List<Book> findByAgeGreaterThanEqual(Long age, Sort sort);

    List<Book> findByPublishDateAfter(LocalDateTime publishDate, Pageable pageable);

    List<Book> findByTitleContains(String title);

    boolean existsByAuthor(String author);

    List<Book> findByAuthorAndAgeGreaterThan(String author,Long age);

    long countByAuthor(String author);


    @Query("select b from Book b where b.title= :title")
    Book findByTitleQuery(String title);

    @Query("select b from Book b where b.age >= :age")
    List<Book> findByAgeGreaterThanEqualQuery(Long age, Sort sort);

    @Query("select b from Book b where b.publishDate> :publishDate")
    List<Book> findByPublishDateAfterQuery(LocalDateTime publishDate, Pageable pageable);

    @Query("select b from Book b where b.title like %:title%")
    List<Book> findByTitleContainsQuery(String title);

    @Query("select b from Book b where b.author= :author and b.age> :age")
    List<Book> findByAuthorAndAgeGreaterThanQuery(String author,Long age);

    @Query("select count(b) from Book b where b.author = :author")
    long countByAuthorQuery(String author);


}

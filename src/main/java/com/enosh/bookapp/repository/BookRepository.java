package com.enosh.bookapp.repository;

import com.enosh.bookapp.entities.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Modifying
    @Query("delete from Book b where b.id = :id")
    void deleteById(@Param("id") Long id);
}

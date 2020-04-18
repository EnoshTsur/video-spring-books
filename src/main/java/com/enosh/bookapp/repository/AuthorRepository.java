package com.enosh.bookapp.repository;

import com.enosh.bookapp.entities.Author;
import com.enosh.bookapp.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}

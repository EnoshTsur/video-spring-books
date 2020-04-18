package com.enosh.bookapp.dao;

import com.enosh.bookapp.entities.Author;
import com.enosh.bookapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorDao {

    private AuthorRepository repository;

    @Autowired
    public AuthorDao(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author save(Author author) throws Exception {
        try {
            return repository.save(author);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Author> findById(Long id) {
        return repository.findById(id);
    }

    public List<Author> findAll() {
        return (List<Author>) repository.findAll();
    }

    public Author deleteById(Long id) throws Exception {
        return findById(id).map(it -> {
            repository.delete(it);
            return it;
        }).orElseThrow(() ->
                new Exception("Author by the id " + id + " does not exists")
        );
    }


}

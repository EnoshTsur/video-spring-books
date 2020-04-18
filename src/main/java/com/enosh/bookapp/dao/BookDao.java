package com.enosh.bookapp.dao;

import com.enosh.bookapp.entities.Book;
import com.enosh.bookapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class BookDao {

    private BookRepository repository;
    private AuthorDao authorDao;

    @Autowired
    public BookDao(BookRepository repository, AuthorDao authorDao) {
        this.repository = repository;
        this.authorDao = authorDao;
    }

    public Book create(Book book, Long authorId) throws Exception {
        return authorDao.findById(authorId).map(it -> {
            book.setAuthor(it);
            return repository.save(book);
        }).orElseThrow(() ->
                new Exception("Author by the id " + authorId + " does not exists")
        );
    }

    public Book update(Book book) throws Exception {
        if (book.getId() == null) {
            throw new Exception("Book id can not be null in order to update");
        }
        try {
            return repository.save(book);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public List<Book> findAll() {
        return (List<Book>) repository.findAll();
    }


    public Book deleteById(Long id) throws Exception {
        return findById(id).map(it -> {
            try {
                repository.deleteById(id);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return it;
        }).orElseThrow(() ->
                new Exception("Book by the id " + id + " does not exists")
        );
    }

}

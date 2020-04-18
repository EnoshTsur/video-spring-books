package com.enosh.bookapp.controllers;

import com.enosh.bookapp.dao.AuthorDao;
import com.enosh.bookapp.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// http://localhost:7070/author/byId/9
// http://localhost:7070/author/create

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao dao;

    @Autowired
    public AuthorController(AuthorDao dao) {
        this.dao = dao;
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Optional<Author> author = dao.findById(id);
        return author.isPresent() ?

                ResponseEntity
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(author.get()) :


                ResponseEntity
                        .status(HttpStatus.OK)
                        .contentType(MediaType.TEXT_PLAIN)
                        .body("Author by the id " + id + " does not exists");
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Author author) {
        try {
            Author afterSave = dao.save(author);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(afterSave);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Author author) {
        if (author.getId() == null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("In order to update must provide id");
        }
        return create(author);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            Author deleted = dao.deleteById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(deleted);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }
    }
}

package com.enosh.bookapp;

import com.enosh.bookapp.dao.AuthorDao;
import com.enosh.bookapp.entities.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
class AuthorTests {

    @Autowired
    private AuthorDao dao;

    @Test
    void contextLoads() {
    }

    @Test
    void create() {
//        Author author = new Author("Efraim", "Shany");
//        try {
//
//            Author afterSave = dao.save(author);
//            System.out.println(afterSave);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    void update() {
//        Author author = new Author(6L, "Effy", "Ron");
//        try {
//
//            Author afterUpdate = dao.save(author);
//            System.out.println(afterUpdate);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    void findById() {
//        dao.findById(1L).ifPresent(System.out::println);
    }

    @Test
    void findAll(){
//        dao.findAll().forEach(System.out::println);
    }

    @Test
    void delete(){
//        try {
//            Author deleted = dao.deleteById(6L);
//            System.out.println(deleted);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

}

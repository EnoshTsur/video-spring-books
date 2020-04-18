package com.enosh.bookapp;

import com.enosh.bookapp.dao.BookDao;
import com.enosh.bookapp.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class BookTests {

    @Autowired
    private BookDao dao;

    @Test
    void contextLoads() {
    }

    @Test
    void create() {
//        Book book = new Book(
//                "Goodies tov",
//                LocalDate.now().minusYears(2),
//                170.90
//        );
//
//        try {
//            Book afterSave = dao.create(book, 30L);
//            System.out.println(afterSave);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    void update() {
//        dao.findById(4L).ifPresent(it -> {
//
//            it.setPrice(10.999);
//            it.setTitle("Kol yom yom");
//            try {
//                dao.update(it);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        });
    }

    @Test
    void findById() {
//        dao.findById(1L).ifPresent(System.out::println);
    }

    @Test
    void  findAll() {
//        dao.findAll().forEach(System.out::println);
    }

    @Test
    void delete() {
//        try {
//            Book deleted = dao.deleteById(4L);
//            System.out.println(deleted);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}

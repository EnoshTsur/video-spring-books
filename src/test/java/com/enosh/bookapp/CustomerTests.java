package com.enosh.bookapp;

import com.enosh.bookapp.dao.CustomerDao;
import com.enosh.bookapp.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerTests {

    @Autowired
    private CustomerDao dao;

    @Test
    void contextLoads() {
    }

    @Test
    void create() {
//        Customer customer = new Customer(
//                "Iftach",
//                "Zokobi",
//                "i@jjjjj",
//                "12349"
//        );
//
//        try {
//
//            Customer afterSave = dao.save(customer);
//            System.out.println(afterSave);
//
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    void update() {
//        Customer customer = new Customer(
//                6L,
//                "Ifti",
//                "Zokoba",
//                "i@omjhkj",
//                "1234"
//        );
//
//        try {
//
//            Customer afterSave = dao.save(customer);
//            System.out.println(afterSave);
//
//        } catch (Exception e) {
//
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
    void deleteById() {
//        try {
//            Customer deleted = dao.deleteById(6L);
//            System.out.println(deleted);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    void addPurchase() {
//        try {
//            dao.addPurchase(4L, 1L);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    void removePurchase(){
        try {
            dao.removePurchase(4L, 1L);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

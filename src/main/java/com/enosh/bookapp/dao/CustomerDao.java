package com.enosh.bookapp.dao;

import com.enosh.bookapp.entities.Book;
import com.enosh.bookapp.entities.Customer;
import com.enosh.bookapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDao {

    private CustomerRepository repository;
    private BookDao bookDao;

    @Autowired
    public CustomerDao(CustomerRepository repository, BookDao bookDao) {
        this.repository = repository;
        this.bookDao = bookDao;
    }

    public Customer save(Customer customer) throws Exception {
        try {
            return repository.save(customer);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    public Customer deleteById(Long id) throws Exception {
        return findById(id).map(it -> {
            repository.delete(it);
            return it;
        }).orElseThrow(() ->
                new Exception("Customer By The Id" + id + " Doest not exists")
        );
    }

    public void addPurchase(Long customerId, Long bookId) throws Exception {
        try {
            findById(customerId).ifPresent(customer ->
                    bookDao.findById(bookId).ifPresent(book -> {
                        if (!customer.getBooks().contains(book)) {
                            customer.getBooks().add(book);
                            repository.save(customer);
                        }
                    }));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void removePurchase(Long customerId, Long bookId) throws Exception {
        try {
            repository.deleteCustomerBook(customerId, bookId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

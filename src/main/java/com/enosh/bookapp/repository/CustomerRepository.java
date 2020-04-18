package com.enosh.bookapp.repository;

import com.enosh.bookapp.entities.Book;
import com.enosh.bookapp.entities.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Modifying
    @Query(
            value = "delete from customer_books where customers_id = :customerId and books_id = :bookId",
            nativeQuery = true
    )
    void deleteCustomerBook(@Param("customerId") Long customerId, @Param("bookId") Long bookId);
}

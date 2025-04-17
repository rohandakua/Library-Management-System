package com.library.management.libraryManagementSystem.repository;

import com.library.management.libraryManagementSystem.entity.Transaction;
import com.library.management.libraryManagementSystem.entity.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {
    @Query("SELECT t FROM Transaction t WHERE t.id.user_id = :userId AND t.id.book_id = :bookId AND t.returnedAt IS NULL")
    Optional<Transaction> findTopByIduserIdAndIdbookIdAndreturnedAtIsNull(@Param("userId") long userId, @Param("bookId") long bookId);

    @Query("SELECT t FROM Transaction t WHERE t.id.user_id = :userId AND t.returnedAt IS NULL")
    List<Transaction> findAllByIduserIdAndreturnedAtIsNull(@Param("userId") long userId);

}


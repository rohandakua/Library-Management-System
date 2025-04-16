package com.library.management.repository;

import com.library.management.entity.Transaction;
import com.library.management.entity.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {
    Optional<Transaction> findTopByIdUserIdAndIdBookIdAndReturnedAtIsNull(long userId, long bookId);
    List<Transaction> findAllByIdUserIdAndReturnedAtIsNull(long userId);

}

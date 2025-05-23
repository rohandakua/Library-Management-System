package com.library.management.libraryManagementSystem.service.implementations;

import com.library.management.libraryManagementSystem.entity.*;
import com.library.management.libraryManagementSystem.repository.BookAvailableRepository;
import com.library.management.libraryManagementSystem.repository.TransactionRepository;
import com.library.management.libraryManagementSystem.repository.UserRepository;
import com.library.management.libraryManagementSystem.service.interfaces.BookTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BookTransactionServiceImplementation implements BookTransactionService {

    @Autowired
    TransactionRepository transactionRepository = null;
    @Autowired
    BookAvailableRepository bookAvailableRepository = null;
    @Autowired
    UserRepository userRepository = null;

    public BookTransactionServiceImplementation (TransactionRepository tr , BookAvailableRepository bar, UserRepository ur){
        transactionRepository = tr;
        bookAvailableRepository = bar;
        userRepository = ur;
    }

    @Override
    public boolean issueBook(long userIdFB, long bookIdFB) {
        Optional<BookAvailable> optionalAvailable = bookAvailableRepository
                .findFirstByBookBookIdAndAvailableTrue(bookIdFB);

        User u = userRepository.findById(userIdFB).orElse(null);
        if (optionalAvailable.isEmpty() || u==null) return false;

        BookAvailable availableBook = optionalAvailable.get();
        availableBook.setAvailable(false);
        bookAvailableRepository.save(availableBook);

        Transaction transaction = new Transaction();
        TransactionId id = new TransactionId(bookIdFB, userIdFB, availableBook.getId().getCopy_no());
        transaction.setId(id);
        transaction.setBook(availableBook.getBook());
        transaction.setBookAvailable(availableBook);
        transaction.setUser(u);
        transaction.setIssued_at(new Timestamp(System.currentTimeMillis()));
        transaction.setFine(0);
        transaction.setFine_returned(false);

        transactionRepository.save(transaction);
        return true;
    }


    @Override
    public boolean returnBook(long userIdFB, long bookIdFB) {
        Optional<Transaction> optionalTransaction = transactionRepository
                .findTopByIduserIdAndIdbookIdAndreturnedAtIsNull(userIdFB, bookIdFB);

        if (optionalTransaction.isEmpty()) return false;

        Transaction transaction = optionalTransaction.get();
        transaction.setReturnedAt(new Timestamp(System.currentTimeMillis()));

        BookAvailableId bookAvailableId = new BookAvailableId(bookIdFB, transaction.getId().getCopy_no());
        Optional<BookAvailable> optionalAvailable = bookAvailableRepository.findById(bookAvailableId);

        optionalAvailable.ifPresent(bookAvailable -> {
            bookAvailable.setAvailable(true);
            bookAvailableRepository.save(bookAvailable);
        });

        transactionRepository.save(transaction);
        return true;
    }


    @Override
    public int calculateFine(long userIdFB, long bookIdFB) {
        Optional<Transaction> optionalTransaction = transactionRepository
                .findTopByIduserIdAndIdbookIdAndreturnedAtIsNull(userIdFB, bookIdFB);

        if (optionalTransaction.isEmpty()) return 0;

        Transaction transaction = optionalTransaction.get();
        long daysElapsed = Duration.between(transaction.getIssued_at().toInstant(), Instant.now()).toDays();

        int fine = (int) Math.max(0, daysElapsed - 14) * 10;
        transaction.setFine(fine);
        transactionRepository.save(transaction);

        return fine;
    }


    @Override
    public List<Transaction> getAllBooksIssuedByUser(long userIdFB) {
        return transactionRepository.findAllByIduserIdAndreturnedAtIsNull(userIdFB);
    }

}

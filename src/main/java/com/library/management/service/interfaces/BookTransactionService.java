package com.library.management.service.interfaces;

import com.library.management.entity.Transaction;

import java.util.List;

public interface BookTransactionService {
    public boolean issueBook (long userIdFB, long bookIdFB);
    public boolean returnBook (long userIdFB, long bookIdFB);
    public int calculateFine (long userIdFB, long bookIdFB);
    public List<Transaction> getAllBooksIssuedByUser (long userIdFB);

}

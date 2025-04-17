package com.library.management.libraryManagementSystem.controller;


import com.library.management.libraryManagementSystem.entity.Book;
import com.library.management.libraryManagementSystem.entity.Transaction;
import com.library.management.libraryManagementSystem.service.implementations.BookServiceImplementation;
import com.library.management.libraryManagementSystem.service.implementations.BookTransactionServiceImplementation;
import com.library.management.libraryManagementSystem.service.implementations.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserServiceImplementation userService;

    @Autowired
    private BookServiceImplementation bookService;

    @Autowired
    private BookTransactionServiceImplementation bookTransactionService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam long userId, @RequestParam String password) {
        boolean success = userService.logIn(userId, password);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(bookService.getBooks(offset, limit));
    }

    @GetMapping("/{genre}/books")
    public ResponseEntity<List<Book>> getBooksByGenre(
            @PathVariable long genre,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(bookService.getBooksByGenre(genre, offset, limit));
    }

    @GetMapping("/issue")
    public ResponseEntity<?> issueBook(
            @RequestParam long bookId,
            @RequestParam long userId) {
        boolean success = bookTransactionService.issueBook(userId, bookId);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/return")
    public ResponseEntity<?> returnBook(
            @RequestParam long bookId,
            @RequestParam long userId) {
        boolean success = bookTransactionService.returnBook(userId, bookId);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/return/fine")
    public ResponseEntity<Integer> getReturnFine(
            @RequestParam long bookId,
            @RequestParam long userId) {
        int fine = bookTransactionService.calculateFine(userId, bookId);
        return ResponseEntity.ok(fine);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam long userId) {
        boolean success = userService.logOut(userId);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/dashboard")
    public ResponseEntity<List<Transaction>> getDashboard(@RequestParam long userId) {
        return ResponseEntity.ok(bookTransactionService.getAllBooksIssuedByUser(userId));
    }
}

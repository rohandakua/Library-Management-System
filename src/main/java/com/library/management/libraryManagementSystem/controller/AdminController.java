package com.library.management.libraryManagementSystem.controller;

import com.library.management.libraryManagementSystem.entity.Admin;
import com.library.management.libraryManagementSystem.entity.Book;
import com.library.management.libraryManagementSystem.entity.Genre;
import com.library.management.libraryManagementSystem.entity.Transaction;
import com.library.management.libraryManagementSystem.service.implementations.AdminServiceImplementation;
import com.library.management.libraryManagementSystem.service.implementations.BookServiceImplementation;
import com.library.management.libraryManagementSystem.service.implementations.BookTransactionServiceImplementation;
import com.library.management.libraryManagementSystem.service.implementations.GenreServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminServiceImplementation adminService;

    @Autowired
    private BookServiceImplementation bookService;

    @Autowired
    private BookTransactionServiceImplementation bookTransactionService;

    @Autowired
    private GenreServiceImplementation genreService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam long adminId, @RequestParam String password) {
        boolean success = adminService.logIn(adminId, password);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam long adminId) {
        boolean success = adminService.logOut(adminId);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Admin> getDashboard(@RequestParam long adminId) {
        Admin admin = adminService.getAdminInfo(adminId);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/query")
    public ResponseEntity<?> queryUser(
            @RequestParam long userId,
            @RequestParam(required = false) Long bookId) {
        if (bookId != null) {
            List<Transaction> transactions = bookTransactionService.getAllBooksIssuedByUser(userId);
            return ResponseEntity.ok(transactions);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/entry")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        boolean success = bookService.addBook(book);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBook(@RequestParam long bookId) {
        boolean success = bookService.deleteBookById(bookId);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBook(
            @RequestParam long bookId,
            @RequestParam(required = false) Long userId,
            @RequestBody Book book) {
        boolean success = bookService.updateBook(book, bookId);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/genres/{genreId}")
    public ResponseEntity<Genre> getGenreById(@PathVariable long genreId) {
        Genre genre = genreService.getGenreById(genreId);
        if (genre != null) {
            return ResponseEntity.ok(genre);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/genres")
    public ResponseEntity<?> addGenre(@RequestBody Genre genre) {
        boolean success = genreService.addGenre(genre);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/genres/{genreId}")
    public ResponseEntity<?> deleteGenre(@PathVariable long genreId) {
        boolean success = genreService.deleteGenre(genreId);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}

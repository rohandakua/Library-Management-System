package com.library.management.libraryManagementSystem.service.interfaces;

import com.library.management.libraryManagementSystem.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBooks(int offset , int limit);
    public List<Book> getBooksByGenre( long genreIdFB ,int offset , int limit);
    public Book getBookById(long bookIdFB);
    public boolean deleteBookById(long bookIdFB);
    public boolean updateBook(Book book,long bookIdFB);
    public boolean addBook(Book book);

}

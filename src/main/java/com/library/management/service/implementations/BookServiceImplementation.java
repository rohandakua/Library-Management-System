package com.library.management.service.implementations;

import com.library.management.entity.Book;
import com.library.management.repository.BookRepository;
import com.library.management.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImplementation implements BookService {
    @Autowired
    BookRepository bookRepository = null;

    public BookServiceImplementation (BookRepository br){
        bookRepository = br;
    }


    @Override
    public List<Book> getBooks(int offset , int limit) {
        List<Book> lst = bookRepository.findAll();
        if(lst.size()<offset+limit){
            return lst;
        }
        return lst.subList(offset,offset+limit);

    }

    @Override
    public List<Book> getBooksByGenre( long genreIdFB , int offset , int limit) {
        List<Book> lst = bookRepository.findByGenre(genreIdFB);
        if(lst.size()<offset+limit){
            return lst;
        }
        return lst.subList(offset,offset+limit);
    }

    @Override
    public Book getBookById(long bookIdFB) {
        return bookRepository.findById(bookIdFB).orElse(null);
    }

    @Override
    public boolean deleteBookById(long bookIdFB) {
        if(getBookById(bookIdFB)!=null){
            bookRepository.deleteById(bookIdFB);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBook(Book bookFB, long bookIdFB) {
        Book book = getBookById(bookIdFB);
        if(book!=null){
            book.setBook_name(bookFB.getBook_name());
            book.setIsbn(bookFB.getIsbn());
            book.setGenre(bookFB.getGenre()); // or setGenre_id if needed
            book.setAuthor_name(bookFB.getAuthor_name());
            book.setPublication_year(bookFB.getPublication_year());
            book.setNo_of_copies(bookFB.getNo_of_copies());
            bookRepository.save(book);
            return true;
        }
        return false;
    }
}

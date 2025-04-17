package com.library.management.libraryManagementSystem.repository;

import com.library.management.libraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    //List<Book> findByGenre(long genre_id);

    @Query("SELECT b FROM Book b WHERE b.genre_id = :genreId")
    List<Book> findByGenreId(@Param("genreId") long genreId);

}

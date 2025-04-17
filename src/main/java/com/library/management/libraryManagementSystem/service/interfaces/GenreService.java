package com.library.management.libraryManagementSystem.service.interfaces;


import com.library.management.libraryManagementSystem.entity.Genre;
import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
    Genre getGenreById(long genreId);
    boolean addGenre(Genre genre);
    boolean deleteGenre(long genreId);
}
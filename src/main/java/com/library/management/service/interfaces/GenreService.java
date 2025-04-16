package com.library.management.service.interfaces;


import com.library.management.entity.Genre;
import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
    Genre getGenreById(long genreId);
    boolean addGenre(Genre genre);
    boolean deleteGenre(long genreId);
}
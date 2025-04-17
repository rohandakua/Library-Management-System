package com.library.management.libraryManagementSystem.service.implementations;
import com.library.management.libraryManagementSystem.entity.Genre;
import com.library.management.libraryManagementSystem.repository.GenreRepository;
import com.library.management.libraryManagementSystem.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImplementation implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(long genreId) {
        return genreRepository.findById(genreId).orElse(null);
    }

    @Override
    public boolean addGenre(Genre genre) {
        try {
            genreRepository.save(genre);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public boolean deleteGenre(long genreId) {
        if (genreRepository.existsById(genreId)) {
            genreRepository.deleteById(genreId);
            return true;
        }
        return false;
    }
}
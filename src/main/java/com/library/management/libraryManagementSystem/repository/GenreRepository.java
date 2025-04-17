package com.library.management.libraryManagementSystem.repository;

import com.library.management.libraryManagementSystem.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}

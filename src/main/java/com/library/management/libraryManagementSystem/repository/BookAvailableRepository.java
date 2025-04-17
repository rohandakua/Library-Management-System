package com.library.management.libraryManagementSystem.repository;

import com.library.management.libraryManagementSystem.entity.BookAvailable;
import com.library.management.libraryManagementSystem.entity.BookAvailableId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookAvailableRepository extends JpaRepository<BookAvailable, BookAvailableId> {
    Optional<BookAvailable> findFirstByBookBookIdAndAvailableTrue(long bookId);

}

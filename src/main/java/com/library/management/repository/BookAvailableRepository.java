package com.library.management.repository;

import com.library.management.entity.BookAvailable;
import com.library.management.entity.BookAvailableId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookAvailableRepository extends JpaRepository<BookAvailable, BookAvailableId> {
    Optional<BookAvailable> findFirstByBookBookIdAndAvailableTrue(long bookId);

}

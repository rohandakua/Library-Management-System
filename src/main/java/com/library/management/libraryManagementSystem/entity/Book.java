package com.library.management.libraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long bookId;

    @Column
    private String book_name;
    @Column
    private String isbn;

    @Column
    private long genre_id;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false, insertable = false, updatable = false)
    private Genre genre;

    @Column
    private String author_name;

    @Column
    private Year publication_year;

    @Column
    private int no_of_copies;

}

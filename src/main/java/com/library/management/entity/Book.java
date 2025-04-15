package com.library.management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Date;

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
    private long book_id;

    @Column
    private String book_name;
    @Column
    private String isbn;

    @Column
    private long genre_id;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Column
    private String author_name;

    @Column
    private Year publication_year;

    @Column
    private int no_of_copies;

}

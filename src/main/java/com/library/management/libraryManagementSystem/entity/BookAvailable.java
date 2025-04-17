package com.library.management.libraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookAvailable")
public class BookAvailable {
    @EmbeddedId
    @NonNull
    private BookAvailableId id;

    @MapsId("book_id")
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(columnDefinition = "boolean default true")
    private boolean available;
}

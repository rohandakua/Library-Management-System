package com.library.management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.MapKeyCompositeType;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @EmbeddedId
    @NonNull
    private TransactionId id;

    @Column
    private Timestamp issued_at;

    @Column(columnDefinition = "int default 0")
    private int fine;
    @Column
    private boolean fine_returned;

    @Column
    private Timestamp returned_at;

    @MapsId("user_id")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("book_id")
    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "book_id", referencedColumnName = "book_id", insertable = false, updatable = false),
            @JoinColumn(name = "copy_no", referencedColumnName = "copy_no", insertable = false, updatable = false)
    })
    private BookAvailable bookAvailable;

}

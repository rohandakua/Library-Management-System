package com.library.management.libraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    private String fn;
    @Column
    private String mn;
    @Column
    private String ln;

    @Column
    private String password;

}

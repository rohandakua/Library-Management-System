package com.library.management.libraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loggedInUser")
public class LoggedInUser {

    @Id
    private long user_id;

    @Column
    private String jwt;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}

package com.library.management.libraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loggedInAdmin")
public class LoggedInAdmin {

    @Id
    @NonNull
    private long admin_id;

    @Column
    private String jwt;

    @ManyToOne
    @MapsId("admin_id")
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

}

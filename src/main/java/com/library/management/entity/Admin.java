package com.library.management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long admin_id;

    @Column
    private String fn;
    @Column
    private String mn;
    @Column
    private String ln;

    @Column
    private String password;

}

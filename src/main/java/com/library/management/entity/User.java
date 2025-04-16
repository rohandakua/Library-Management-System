package com.library.management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long user_id;

    @Column
    private String fn;
    @Column
    private String mn;
    @Column
    private String ln;

    @Column
    private String password;

}

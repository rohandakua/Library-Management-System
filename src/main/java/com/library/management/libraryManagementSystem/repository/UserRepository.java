package com.library.management.libraryManagementSystem.repository;

import com.library.management.libraryManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

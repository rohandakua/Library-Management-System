package com.library.management.libraryManagementSystem.repository;

import com.library.management.libraryManagementSystem.entity.LoggedInUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggedInUserRepository extends JpaRepository<LoggedInUser,Long> {
}

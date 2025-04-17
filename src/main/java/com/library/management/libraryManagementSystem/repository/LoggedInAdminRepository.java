package com.library.management.libraryManagementSystem.repository;

import com.library.management.libraryManagementSystem.entity.LoggedInAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggedInAdminRepository extends JpaRepository<LoggedInAdmin,Long> {
}

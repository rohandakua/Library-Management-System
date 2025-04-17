package com.library.management.libraryManagementSystem.repository;

import com.library.management.libraryManagementSystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}

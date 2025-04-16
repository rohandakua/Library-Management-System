package com.library.management.repository;

import com.library.management.entity.LoggedInAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggedInAdminRepository extends JpaRepository<LoggedInAdmin,Long> {
}

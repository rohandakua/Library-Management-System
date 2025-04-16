package com.library.management.repository;

import com.library.management.entity.LoggedInUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggedInUserRepository extends JpaRepository<LoggedInUser,Long> {
}

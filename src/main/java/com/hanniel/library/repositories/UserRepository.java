package com.hanniel.library.repositories;

import com.hanniel.library.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

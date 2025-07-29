package com.rooflyn.account.repositories;

import com.rooflyn.account.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmailAndIdNot(String email, UUID userId);
}

package com.rooflyn.account.repositories;

import com.rooflyn.account.models.LandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LandLordRepository extends JpaRepository<LandLord, UUID> {
    boolean existsByEmail(String email);
}

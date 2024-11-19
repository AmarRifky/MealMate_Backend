package lk.mealmate.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    Optional<Admin> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByPassword(String password);
    Boolean existsByEmail(String email);
    // Boolean existsByEmail(String adminEmail);
}

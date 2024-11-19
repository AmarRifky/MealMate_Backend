package lk.mealmate.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.Admin;
import lk.mealmate.backend.entity.User;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.entity.UserRole;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findUsersByRole(@Param("role") UserRole role);

    @Query("SELECT p FROM Admin p WHERE p.role = :role")
    List<Admin> findAdminsByRole(@Param("role") UserRole role);
}

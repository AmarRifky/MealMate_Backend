package lk.mealmate.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.ExternalServicesEntity;
import lk.mealmate.backend.entity.UserEntity;

@Repository
public interface ExternalServiceRepository extends JpaRepository<ExternalServicesEntity, Long> {
    @Query("SELECT p FROM ExternalServicesEntity p WHERE p.userEntity = :userEntity")
    List<ExternalServicesEntity> findUsersByUser(@Param("userEntity") UserEntity userEntity);

}

package lk.mealmate.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.CommunityInteractionEntity;
import lk.mealmate.backend.entity.UserEntity;

@Repository
public interface ComIntRepository extends JpaRepository<CommunityInteractionEntity, Long> {
    @Query("SELECT p FROM CommunityInteractionEntity p WHERE p.userEntity = :userEntity")
    List<CommunityInteractionEntity> findUsersByUser(@Param("userEntity") UserEntity userEntity);

}

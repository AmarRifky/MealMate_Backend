package lk.mealmate.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.PersonalizedRecommendationEntity;
import lk.mealmate.backend.entity.UserEntity;

@Repository
public interface PersonalizedRecomRepository extends JpaRepository<PersonalizedRecommendationEntity, Long> {
    @Query("SELECT p FROM PersonalizedRecommendationEntity p WHERE p.userEntity = :userEntity")
    List<PersonalizedRecommendationEntity> findUsersByUser(@Param("userEntity") UserEntity userEntity);

}

package lk.mealmate.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.RatingsEntity;
import lk.mealmate.backend.entity.RecipeEntity;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long>{
    // Optional<AdminEntity> findByUsername(String username);
    // Boolean existsByUsername(String username);
    // Boolean existsByEmail(String email);

    @Query("SELECT p FROM RecipeEntity p WHERE p.ratingsEntity = :ratingsEntity")
    List<RecipeEntity> findRatingsByRecipe(@Param("ratingsEntity") RatingsEntity ratingsEntity);

}

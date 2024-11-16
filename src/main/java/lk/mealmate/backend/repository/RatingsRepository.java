package lk.mealmate.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.CommentsEntity;
import lk.mealmate.backend.entity.RatingsEntity;
import lk.mealmate.backend.entity.RecipeEntity;
import lk.mealmate.backend.entity.UserEntity;

@Repository
public interface RatingsRepository extends JpaRepository<RatingsEntity, Long> {
    @Query("SELECT p FROM RatingsEntity p WHERE p.userEntity = :userEntity")
    List<RatingsEntity> findUsersByUser(@Param("userEntity") UserEntity userEntity);

    @Query("SELECT p FROM RatingsEntity p WHERE p.recipeEntity = :recipeEntity")
    List<RatingsEntity> findRatingByRecipe(@Param("recipeEntity") RecipeEntity recipeEntity);

    @Query("SELECT p FROM RatingsEntity p WHERE p.commentsEntity = :commentsEntity")
    List<RatingsEntity> findCommentsByRatings(@Param("commentsEntity") CommentsEntity commentsEntity);

}

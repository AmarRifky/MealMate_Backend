package lk.mealmate.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.CommentsEntity;
import lk.mealmate.backend.entity.RatingsEntity;
import lk.mealmate.backend.entity.UserEntity;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {
    @Query("SELECT p FROM CommentsEntity p WHERE p.userEntity = :userEntity")
    List<CommentsEntity> findUsersByUser(@Param("userEntity") UserEntity userEntity);

    @Query("SELECT q FROM CommentsEntity q WHERE q.ratingsEntity = :ratingsEntity")
    List<CommentsEntity> addratings(@Param("ratingsEntity") RatingsEntity ratingsEntity);

}
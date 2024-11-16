package lk.mealmate.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.mealmate.backend.entity.AdminEntity;
import lk.mealmate.backend.entity.CustomizedRecipeEntity;
import lk.mealmate.backend.entity.UserEntity;

@Repository
public interface CustomRecipeRepository extends JpaRepository<CustomizedRecipeEntity, Long> {
    // Find customized recipes by associated user
    @Query("SELECT p FROM CustomizedRecipeEntity p WHERE p.userEntity = :userEntity")
    List<CustomizedRecipeEntity> findRecipesByUser(@Param("userEntity") UserEntity userEntity);

    // Find customized recipes added by an admin
    @Query("SELECT p FROM CustomizedRecipeEntity p WHERE p.adminEntity = :adminEntity")
    List<CustomizedRecipeEntity> findRecipesByAdmin(@Param("adminEntity") AdminEntity adminEntity);

}

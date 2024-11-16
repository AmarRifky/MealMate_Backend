package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.AddRecipeDto;
import lk.mealmate.backend.entity.RecipeEntity;


@Service
public interface RecipeService {
    List<RecipeEntity> getAllRecipes();
    RecipeEntity createRecipe(AddRecipeDto addRecipeDto);
    RecipeEntity updateRecipe(RecipeEntity recuiEntity);
    RecipeEntity deleteRecipe(Long id);
    RecipeEntity getRecipeById(Long id);
}

package lk.mealmate.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.AddRecipeDto;
import lk.mealmate.backend.entity.AdminEntity;
import lk.mealmate.backend.entity.RatingsEntity;
import lk.mealmate.backend.entity.RecipeEntity;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.AdminRepository;
import lk.mealmate.backend.repository.RatingsRepository;
import lk.mealmate.backend.repository.RecipeRepository;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{
    
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RatingsRepository ratingsRepository;

    /**
     * Retrieves all recipes from the repository.
     * @return List of RecipeEntity.
     */
    @Override
    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    /**
     * Creates a new recipe based on the provided DTO.
     * @param addRecipeDto Data Transfer Object containing recipe details.
     * @return Created RecipeEntity.
     */
    @Override
    public RecipeEntity createRecipe(AddRecipeDto addRecipeDto) {
        RecipeEntity recipeEntity = new RecipeEntity();
        UserEntity userEntity = userRepository.findById(addRecipeDto.getUserID()).orElse(null);
        AdminEntity adminEntity = adminRepository.findById(addRecipeDto.getAdminId()).orElse(null);
        RatingsEntity ratingsEntity = ratingsRepository.findById(addRecipeDto.getRateID()).orElse(null);
        recipeEntity.setRecipeName(addRecipeDto.getRecipeName());
        recipeEntity.setUserEntity(userEntity);
        recipeEntity.setAdminEntity(adminEntity);
        recipeEntity.setInstructions(addRecipeDto.getInstructions());
        recipeEntity.setIngredients(addRecipeDto.getIngredients());
        recipeEntity.setRatingsEntity(ratingsEntity);

        return recipeRepository.save(recipeEntity);
    }

    /**
     * Updates an existing recipe.
     * @param recipeEntity The recipe entity with updated information.
     * @return Updated RecipeEntity.
     */
    @Override
    public RecipeEntity updateRecipe(RecipeEntity recipeEntity) {
        // Check if the entity exists before saving
        if (recipeRepository.existsById(recipeEntity.getId())) {
            return recipeRepository.save(recipeEntity);
        }
        return null; // Or throw an exception if preferred
    }

    /**
     * Deletes a recipe by its ID.
     * @param id ID of the recipe to delete.
     * @return Deleted RecipeEntity, or null if not found.
     */
    @Override
    public RecipeEntity deleteRecipe(Long id) {
        Optional<RecipeEntity> optionalRecipeEntity = recipeRepository.findById(id);
        if (optionalRecipeEntity.isPresent()) {
            RecipeEntity recipeEntity = optionalRecipeEntity.get();
            recipeRepository.delete(recipeEntity);
            return recipeEntity;
        }
        return null; // Or throw an exception if preferred
    }

    /**
     * Retrieves a recipe by its ID.
     * @param id ID of the recipe to retrieve.
     * @return RecipeEntity if found, otherwise null.
     */
    @Override
    public RecipeEntity getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }
}

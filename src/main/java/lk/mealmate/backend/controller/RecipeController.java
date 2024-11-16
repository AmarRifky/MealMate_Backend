package lk.mealmate.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.mealmate.backend.dto.AddRecipeDto;
import lk.mealmate.backend.entity.RecipeEntity;
import lk.mealmate.backend.service.RecipeService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    /**
     * Get all recipes.
     *
     * @return a list of RecipeEntity objects.
     */
    @GetMapping
    public ResponseEntity<List<RecipeEntity>> getAllRecipes() {
        List<RecipeEntity> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    /**
     * Get a recipe by its ID.
     *
     * @param id the ID of the recipe to retrieve.
     * @return the RecipeEntity object with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecipeEntity> getRecipeById(@PathVariable Long id) {
        RecipeEntity recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe);
    }

    /**
     * Create a new recipe.
     *
     * @param addRecipeDto the DTO containing recipe details.
     * @return the created RecipeEntity object.
     */
    @PostMapping
    public ResponseEntity<RecipeEntity> createRecipe(@RequestBody AddRecipeDto addRecipeDto) {
        RecipeEntity createdRecipe = recipeService.createRecipe(addRecipeDto);
        return ResponseEntity.ok(createdRecipe);
    }

    /**
     * Update an existing recipe.
     *
     * @param id           the ID of the recipe to update.
     * @param recipeEntity the updated RecipeEntity object.
     * @return the updated RecipeEntity object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RecipeEntity> updateRecipe(@PathVariable Long id, @RequestBody RecipeEntity recipeEntity) {
        recipeEntity.setId(id); // Ensure the correct ID is set
        RecipeEntity updatedRecipe = recipeService.updateRecipe(recipeEntity);
        return ResponseEntity.ok(updatedRecipe);
    }

    /**
     * Delete a recipe by ID.
     *
     * @param id the ID of the recipe to delete.
     * @return the deleted RecipeEntity object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<RecipeEntity> deleteRecipe(@PathVariable Long id) {
        RecipeEntity deletedRecipe = recipeService.deleteRecipe(id);
        return ResponseEntity.ok(deletedRecipe);
    }
}

package lk.mealmate.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.mealmate.backend.dto.CustomizedRecipeDto;
import lk.mealmate.backend.dto.PersonalizedRecoDto;
import lk.mealmate.backend.entity.CustomizedRecipeEntity;
import lk.mealmate.backend.service.CustomRecipeService;

@RestController
@RequestMapping("/api/customized-recipes")
@CrossOrigin(origins = "*")
public class CustomRecipeController {
    @Autowired
    private CustomRecipeService customRecipeService;

    /**
     * Retrieves a list of all customized recipes.
     * 
     * @return A list of CustomizedRecipeEntity objects.
     */
    @GetMapping
    public ResponseEntity<List<CustomizedRecipeEntity>> getAllCustomizedRecipes() {
        List<CustomizedRecipeEntity> recipes = customRecipeService.getAllcustomizedRecipe();
        return ResponseEntity.ok(recipes);
    }

    /**
     * Retrieves a specific customized recipe by its ID.
     * 
     * @param id The ID of the customized recipe to retrieve.
     * @return The CustomizedRecipeEntity object with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomizedRecipeEntity> getCustomizedRecipeById(@PathVariable Long id) {
        CustomizedRecipeEntity recipe = customRecipeService.getCusotmizedRecipebyID(id);
        return ResponseEntity.ok(recipe);
    }

    /**
     * Creates a new customized recipe.
     * 
     * @param customizedRecipeDto Data transfer object containing the details of the
     *                            customized recipe.
     * @return The created CustomizedRecipeEntity object.
     */
    @PostMapping
    public ResponseEntity<CustomizedRecipeEntity> createCustomizedRecipe(
            @RequestBody CustomizedRecipeDto customizedRecipeDto) {
        CustomizedRecipeEntity newRecipe = customRecipeService.createCustomizedRecipe(customizedRecipeDto);
        return ResponseEntity.ok(newRecipe);
    }

    /**
     * Updates an existing customized recipe by its ID.
     * 
     * @param id                     The ID of the customized recipe to update.
     * @param customizedRecipeEntity The updated CustomizedRecipeEntity object.
     * @return The updated CustomizedRecipeEntity object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CustomizedRecipeEntity> updateCustomizedRecipe(@PathVariable Long id,
            @RequestBody CustomizedRecipeEntity customizedRecipeEntity) {
        CustomizedRecipeEntity updatedRecipe = customRecipeService.updateCustomizedRecipe(id, customizedRecipeEntity);
        return ResponseEntity.ok(updatedRecipe);
    }

    /**
     * Retrieves a list of customized recipes based on personalized recommendations.
     * 
     * @param personalizedRecoDto Data transfer object containing the personalized
     *                            recommendation details.
     * @return A list of CustomizedRecipeEntity objects that match the
     *         recommendations.
     */
    @PostMapping("/recommendations")
    public ResponseEntity<List<CustomizedRecipeEntity>> getCustomizedRecipeByPersonalRecommendations(
            @RequestBody PersonalizedRecoDto personalizedRecoDto) {
        List<CustomizedRecipeEntity> recommendedRecipes = customRecipeService
                .getCustomizedRecipeByPersonalRecommendations(personalizedRecoDto);
        return ResponseEntity.ok(recommendedRecipes);
    }

    /**
     * Deletes a specific customized recipe by its ID.
     * 
     * @param id The ID of the customized recipe to delete.
     * @return The deleted CustomizedRecipeEntity object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomizedRecipeEntity> deleteCustomizedRecipe(@PathVariable Long id) {
        CustomizedRecipeEntity deletedRecipe = customRecipeService.deleteCustomizedRecipe(id);
        return ResponseEntity.ok(deletedRecipe);
    }
}

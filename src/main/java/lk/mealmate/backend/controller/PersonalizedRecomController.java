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

import lk.mealmate.backend.dto.PersonalizedRecoDto;
import lk.mealmate.backend.entity.PersonalizedRecommendationEntity;
import lk.mealmate.backend.service.PersonalizedRecomService;


@RestController
@RequestMapping("/api/personalized-recommendations")
@CrossOrigin(origins = "*")
public class PersonalizedRecomController {
    @Autowired
    private PersonalizedRecomService personalizedRecomService;

    /**
     * Retrieves a list of all personalized recommendations.
     * @return A list of PersonalizedRecommendationEntity objects.
     */
    @GetMapping
    public ResponseEntity<List<PersonalizedRecommendationEntity>> getAllPersonalizedRecommendations() {
        List<PersonalizedRecommendationEntity> recommendations = personalizedRecomService.getAllPersonalziedRecommendations();
        return ResponseEntity.ok(recommendations);
    }

    /**
     * Retrieves a specific personalized recommendation by its ID.
     * @param id The ID of the personalized recommendation to retrieve.
     * @return The PersonalizedRecommendationEntity object with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PersonalizedRecommendationEntity> getPersonalizedRecommendationById(@PathVariable Long id) {
        PersonalizedRecommendationEntity recommendation = personalizedRecomService.getPersonalizedRecommendationsById(id);
        return ResponseEntity.ok(recommendation);
    }

    /**
     * Creates a new personalized recommendation.
     * @param personalizedRecoDto Data transfer object containing the details of the personalized recommendation.
     * @return The created PersonalizedRecommendationEntity object.
     */
    @PostMapping
    public ResponseEntity<PersonalizedRecommendationEntity> createPersonalizedRecommendation(@RequestBody PersonalizedRecoDto personalizedRecoDto) {
        PersonalizedRecommendationEntity newRecommendation = personalizedRecomService.createPersonalizedRecommendations(personalizedRecoDto);
        return ResponseEntity.ok(newRecommendation);
    }

    /**
     * Updates an existing personalized recommendation by its ID.
     * @param id The ID of the personalized recommendation to update.
     * @param personalizedRecoDto The updated PersonalizedRecoDto object.
     * @return The updated PersonalizedRecommendationEntity object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PersonalizedRecommendationEntity> updatePersonalizedRecommendation(@PathVariable Long id, @RequestBody PersonalizedRecoDto personalizedRecoDto) {
        // Convert DTO to entity
        PersonalizedRecommendationEntity updatedEntity = new PersonalizedRecommendationEntity();
        // updatedEntity.setRecipeId(personalizedRecoDto.getRecipeId());
        updatedEntity.setRecipeName(personalizedRecoDto.getRecipeName());
        // updatedEntity.setUserID(personalizedRecoDto.getUserID());

        PersonalizedRecommendationEntity updatedRecommendation = personalizedRecomService.updatePersonalizedRecommendations(id, updatedEntity);
        return ResponseEntity.ok(updatedRecommendation);
    }

    /**
     * Deletes a specific personalized recommendation by its ID.
     * @param id The ID of the personalized recommendation to delete.
     * @return The deleted PersonalizedRecommendationEntity object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonalizedRecommendationEntity> deletePersonalizedRecommendation(@PathVariable Long id) {
        PersonalizedRecommendationEntity deletedRecommendation = personalizedRecomService.deletePersonalizedRecommendations(id);
        return ResponseEntity.ok(deletedRecommendation);
    }
}

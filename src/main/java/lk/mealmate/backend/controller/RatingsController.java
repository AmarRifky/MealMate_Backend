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

import lk.mealmate.backend.dto.AddRatingsDto;
import lk.mealmate.backend.entity.RatingsEntity;
import lk.mealmate.backend.service.RatingsService;

@RestController
@RequestMapping("/api/ratings")
public class RatingsController {
    @Autowired
    private RatingsService ratingsService;

    /**
     * Get all ratings.
     *
     * @return a list of RatingsEntity objects.
     */
    @GetMapping
    public ResponseEntity<List<RatingsEntity>> getAllRatings() {
        List<RatingsEntity> ratings = ratingsService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    /**
     * Get a rating by its ID.
     *
     * @param id the ID of the rating to retrieve.
     * @return the RatingsEntity object with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RatingsEntity> getRatingById(@PathVariable Long id) {
        RatingsEntity rating = ratingsService.getRatingsById(id);
        return ResponseEntity.ok(rating);
    }

    /**
     * Create a new rating.
     *
     * @param addRatingsDto the DTO containing rating details.
     * @return the created RatingsEntity object.
     */
    @PostMapping
    public ResponseEntity<RatingsEntity> createRating(@RequestBody AddRatingsDto addRatingsDto) {
        RatingsEntity createdRating = ratingsService.createRatings(addRatingsDto);
        return ResponseEntity.ok(createdRating);
    }

    /**
     * Update an existing rating.
     *
     * @param id            the ID of the rating to update.
     * @param ratingsEntity the updated RatingsEntity object.
     * @return the updated RatingsEntity object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RatingsEntity> updateRating(@PathVariable Long id, @RequestBody RatingsEntity ratingsEntity) {
        ratingsEntity.setId(id); // Ensure the correct ID is set
        RatingsEntity updatedRating = ratingsService.updateRatings(ratingsEntity);
        return ResponseEntity.ok(updatedRating);
    }

    /**
     * Delete a rating by ID.
     *
     * @param id the ID of the rating to delete.
     * @return the deleted RatingsEntity object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<RatingsEntity> deleteRating(@PathVariable Long id) {
        RatingsEntity deletedRating = ratingsService.deleteRatings(id);
        return ResponseEntity.ok(deletedRating);
    }
}

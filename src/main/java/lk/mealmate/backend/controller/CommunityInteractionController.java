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

import lk.mealmate.backend.dto.CommunityInteractionDto;
import lk.mealmate.backend.entity.CommunityInteractionEntity;
import lk.mealmate.backend.service.ComIntService;

@RestController
@RequestMapping("/api/community-interactions")
@CrossOrigin(origins = "*")
public class CommunityInteractionController {
    @Autowired
    private ComIntService comIntService;

    /**
     * Retrieves a list of all community interactions.
     * 
     * @return A list of CommunityInteractionEntity objects.
     */
    @GetMapping
    public ResponseEntity<List<CommunityInteractionEntity>> getAllCommunityInteractions() {
        List<CommunityInteractionEntity> interactions = comIntService.getAllCommunityInteraction();
        return ResponseEntity.ok(interactions);
    }

    /**
     * Retrieves a specific community interaction by its ID.
     * 
     * @param id The ID of the community interaction to retrieve.
     * @return The CommunityInteractionEntity object with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommunityInteractionEntity> getCommunityInteractionById(@PathVariable Long id) {
        CommunityInteractionEntity interaction = comIntService.getCommunityInteractionById(id);
        return ResponseEntity.ok(interaction);
    }

    /**
     * Creates a new community interaction.
     * 
     * @param communityInteractionDto Data transfer object containing interaction
     *                                details.
     * @return The created CommunityInteractionEntity object.
     */
    @PostMapping
    public ResponseEntity<CommunityInteractionEntity> createCommunityInteraction(
            @RequestBody CommunityInteractionDto communityInteractionDto) {
        CommunityInteractionEntity newInteraction = comIntService.createCommunityInteraction(communityInteractionDto);
        return ResponseEntity.ok(newInteraction);
    }

    /**
     * Updates an existing community interaction.
     * 
     * @param id                         The ID of the community interaction to
     *                                   update.
     * @param communityInteractionEntity The updated CommunityInteractionEntity
     *                                   object.
     * @return The updated CommunityInteractionEntity object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CommunityInteractionEntity> updateCommunityInteraction(@PathVariable Long id,
            @RequestBody CommunityInteractionEntity communityInteractionEntity) {
        CommunityInteractionEntity updatedInteraction = comIntService.updateCommunityInteraction(id,
                communityInteractionEntity);
        return ResponseEntity.ok(updatedInteraction);
    }

    /**
     * Deletes a specific community interaction by its ID.
     * 
     * @param id The ID of the community interaction to delete.
     * @return The deleted CommunityInteractionEntity object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CommunityInteractionEntity> deleteCommunityInteraction(@PathVariable Long id) {
        CommunityInteractionEntity deletedInteraction = comIntService.deleteCommunityInteraction(id);
        return ResponseEntity.ok(deletedInteraction);
    }
}

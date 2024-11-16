package lk.mealmate.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.AddRatingsDto;
import lk.mealmate.backend.entity.CommentsEntity;
import lk.mealmate.backend.entity.RatingsEntity;
import lk.mealmate.backend.entity.RecipeEntity;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.CommentsRepository;
import lk.mealmate.backend.repository.RatingsRepository;
import lk.mealmate.backend.repository.RecipeRepository;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.RatingsService;

@Service
public class RatingsServiceImpl implements RatingsService{
    
    @Autowired
    private RatingsRepository ratingsRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    /**
     * Retrieves all ratings.
     * @return List of RatingsEntity.
     */
    @Override
    public List<RatingsEntity> getAllRatings() {
        return ratingsRepository.findAll();
    }

    /**
     * Creates a new rating based on the provided DTO.
     * @param addRatingsDto Data Transfer Object containing rating details.
     * @return Created RatingsEntity.
     */
    @Override
    public RatingsEntity createRatings(AddRatingsDto addRatingsDto) {
        RatingsEntity ratingsEntity = new RatingsEntity();
        RecipeEntity recipeEntity = recipeRepository.findById(addRatingsDto.getRecipeID()).orElse(null);
        UserEntity userEntity = userRepository.findById(addRatingsDto.getUserID()).orElse(null);
        CommentsEntity commentsEntity = commentsRepository.findById(addRatingsDto.getCommentID()).orElse(null);
        ratingsEntity.setRate(addRatingsDto.getRate());
        ratingsEntity.setRecipeEntity(recipeEntity);
        ratingsEntity.setUserEntity(userEntity);
        ratingsEntity.setCommentsEntity(commentsEntity);

        return ratingsRepository.save(ratingsEntity);
    }

    /**
     * Updates an existing rating.
     * @param ratingsEntity The rating entity to update.
     * @return Updated RatingsEntity.
     */
    @Override
    public RatingsEntity updateRatings(RatingsEntity ratingsEntity) {
        return ratingsRepository.save(ratingsEntity);
    }

    /**
     * Deletes a rating by its ID.
     * @param id ID of the rating to delete.
     * @return Deleted RatingsEntity, or null if not found.
     */
    @Override
    public RatingsEntity deleteRatings(Long id) {
        RatingsEntity ratingsEntity = ratingsRepository.findById(id).orElse(null);
        if (ratingsEntity != null) {
            ratingsRepository.delete(ratingsEntity);
        }
        return ratingsEntity;
    }

    /**
     * Retrieves a rating by its ID.
     * @param id ID of the rating to retrieve.
     * @return RatingsEntity if found, otherwise null.
     */
    @Override
    public RatingsEntity getRatingsById(Long id) {
        return ratingsRepository.findById(id).orElse(null);
    }
}

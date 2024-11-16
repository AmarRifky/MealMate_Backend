package lk.mealmate.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.CommentsDto;
import lk.mealmate.backend.entity.CommentsEntity;
import lk.mealmate.backend.entity.RecipeEntity;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.CommentsRepository;
import lk.mealmate.backend.repository.RecipeRepository;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;
    // Create a new comment
    @Override
    public CommentsEntity createComments(CommentsDto commentsDto) {
        CommentsEntity entity = new CommentsEntity();
        UserEntity userEntity = userRepository.findById(commentsDto.getUserID()).orElse(null);
        RecipeEntity recipeEntity = recipeRepository.findById(commentsDto.getRateId()).orElse(null);
        entity.setUserEntity(userEntity);
        entity.setRecipeEntity(recipeEntity);
        entity.setCommentText(commentsDto.getCommentText());
        // Handle relationship setting if needed (userEntity, ratingsEntity)
        return commentsRepository.save(entity);
    }

    // Get a comment by its ID
    @Override
    public CommentsEntity getCommentsById(Long id) {
        return commentsRepository.findById(id)
                .orElseThrow(null);
    }

    // Get all comments
    @Override
    public List<CommentsEntity> getAllComments() {
        return commentsRepository.findAll();
    }

    // Delete a comment by its ID
    @Override
    public CommentsEntity deleteComments(Long id) {
        CommentsEntity existingEntity = commentsRepository.findById(id)
                .orElseThrow(null);
        commentsRepository.delete(existingEntity);
        return existingEntity;
    }
}

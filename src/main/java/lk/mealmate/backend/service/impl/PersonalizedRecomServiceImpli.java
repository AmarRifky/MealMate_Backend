package lk.mealmate.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.PersonalizedRecoDto;
import lk.mealmate.backend.entity.PersonalizedRecommendationEntity;
import lk.mealmate.backend.entity.RecipeEntity;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.PersonalizedRecomRepository;
import lk.mealmate.backend.repository.RecipeRepository;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.PersonalizedRecomService;

@Service
public class PersonalizedRecomServiceImpli implements PersonalizedRecomService{

    @Autowired
    private PersonalizedRecomRepository personalizedRecomRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    // Method to retrieve all personalized recommendations
    @Override
    public List<PersonalizedRecommendationEntity> getAllPersonalziedRecommendations() {
        return personalizedRecomRepository.findAll();
    }

    // Method to create a new personalized recommendation
    @Override
    public PersonalizedRecommendationEntity createPersonalizedRecommendations(PersonalizedRecoDto personalizedRecoDto) {
        PersonalizedRecommendationEntity entity = new PersonalizedRecommendationEntity();
        RecipeEntity recipeEntity = recipeRepository.findById(personalizedRecoDto.getRecipeId()).orElse(null);
        UserEntity userEntity = userRepository.findById(personalizedRecoDto.getUserID()).orElse(null);
        entity.setRecipeEntity(recipeEntity);
        entity.setRecipeName(personalizedRecoDto.getRecipeName());
        entity.setUserEntity(userEntity);
        // Handle user entity assignment if needed (not covered in DTO)
        return personalizedRecomRepository.save(entity);
    }

    // Method to update an existing personalized recommendation
    @Override
    public PersonalizedRecommendationEntity updatePersonalizedRecommendations(Long id, PersonalizedRecommendationEntity updatedEntity) {
        PersonalizedRecommendationEntity existingEntity = personalizedRecomRepository.findById(id)
                .orElseThrow(null);
                RecipeEntity recipeEntity = recipeRepository.findById(updatedEntity.getRecipeEntity().getId()).orElse(null);
                UserEntity userEntity = userRepository.findById(updatedEntity.getUserEntity().getId()).orElse(null);
        // Update fields
        existingEntity.setRecipeEntity(recipeEntity);
        existingEntity.setRecipeName(updatedEntity.getRecipeName());
        existingEntity.setUserEntity(userEntity);
        // Handle user entity assignment if needed

        return personalizedRecomRepository.save(existingEntity);
    }

    // Method to delete a personalized recommendation by ID
    @Override
    public PersonalizedRecommendationEntity deletePersonalizedRecommendations(Long id) {
        PersonalizedRecommendationEntity entity = personalizedRecomRepository.findById(id)
                .orElseThrow(null);
        personalizedRecomRepository.delete(entity);
        return entity;
    }

    // Method to get a personalized recommendation by ID
    @Override
    public PersonalizedRecommendationEntity getPersonalizedRecommendationsById(Long id) {
        return personalizedRecomRepository.findById(id)
                .orElseThrow(null);
    }
    
}

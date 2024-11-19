package lk.mealmate.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.CustomizedRecipeDto;
import lk.mealmate.backend.dto.PersonalizedRecoDto;
import lk.mealmate.backend.entity.Admin;
import lk.mealmate.backend.entity.CustomizedRecipeEntity;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.AdminRepository;
import lk.mealmate.backend.repository.CustomRecipeRepository;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.CustomRecipeService;

@Service
public class CustomRecipeServiceImpl implements CustomRecipeService {
    @Autowired
    private CustomRecipeRepository customRecipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    // Get all customized recipes
    @Override
    public List<CustomizedRecipeEntity> getAllcustomizedRecipe() {
        return customRecipeRepository.findAll();
    }

    // Create a new customized recipe
    @Override
    public CustomizedRecipeEntity createCustomizedRecipe(CustomizedRecipeDto customizedRecipeDto) {
        CustomizedRecipeEntity entity = new CustomizedRecipeEntity();
        UserEntity userEntity = userRepository.findById(customizedRecipeDto.getUserID()).orElse(null);
        Admin adminEntity = adminRepository.findById(customizedRecipeDto.getAdminId()).orElse(null);
        entity.setUserEntity(userEntity);
        entity.setRecipeName(customizedRecipeDto.getRecipeName());
        entity.setCustomInstructions(customizedRecipeDto.getCustomInstructions());
        entity.setAdminEntity(adminEntity);

        return customRecipeRepository.save(entity);
    }

    // Get a customized recipe by its ID
    @Override
    public CustomizedRecipeEntity getCusotmizedRecipebyID(Long id) {
        return customRecipeRepository.findById(id)
                .orElseThrow(null);
    }

    // Update a customized recipe by its ID
    @Override
    public CustomizedRecipeEntity updateCustomizedRecipe(Long id, CustomizedRecipeEntity customizedRecipeEntity) {
        CustomizedRecipeEntity existingEntity = customRecipeRepository.findById(id)
                .orElseThrow(null);

        existingEntity.setRecipeName(customizedRecipeEntity.getRecipeName());
        existingEntity.setCustomInstructions(customizedRecipeEntity.getCustomInstructions());

        // Update relationships if needed (userEntity, adminEntity)
        existingEntity.setUserEntity(customizedRecipeEntity.getUserEntity());
        existingEntity.setAdminEntity(customizedRecipeEntity.getAdminEntity());

        return customRecipeRepository.save(existingEntity);
    }

    // Get customized recipes by personalized recommendations
    @Override
    public List<CustomizedRecipeEntity> getCustomizedRecipeByPersonalRecommendations(
            PersonalizedRecoDto personalizedRecoDto) {
        // Logic to fetch customized recipes based on personalized recommendations
        // Assuming a method in the repository for this purpose
        return null;
    }

    // Delete a customized recipe by its ID
    @Override
    public CustomizedRecipeEntity deleteCustomizedRecipe(Long id) {
        CustomizedRecipeEntity existingEntity = customRecipeRepository.findById(id)
                .orElseThrow(null);

        customRecipeRepository.delete(existingEntity);
        return existingEntity;
    }
}

package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.CustomizedRecipeDto;
import lk.mealmate.backend.dto.PersonalizedRecoDto;
import lk.mealmate.backend.entity.CustomizedRecipeEntity;


@Service
public interface CustomRecipeService {
    List<CustomizedRecipeEntity> getAllcustomizedRecipe();
    CustomizedRecipeEntity createCustomizedRecipe(CustomizedRecipeDto customizedRecipeDto);
    CustomizedRecipeEntity getCusotmizedRecipebyID(Long id);
    CustomizedRecipeEntity updateCustomizedRecipe(Long id, CustomizedRecipeEntity customizedRecipeEntity);
    List<CustomizedRecipeEntity> getCustomizedRecipeByPersonalRecommendations(PersonalizedRecoDto personalizedRecoDto);
    CustomizedRecipeEntity deleteCustomizedRecipe(Long id);
}

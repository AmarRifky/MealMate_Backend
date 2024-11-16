package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.PersonalizedRecoDto;
import lk.mealmate.backend.entity.PersonalizedRecommendationEntity;


@Service
public interface PersonalizedRecomService {
    List<PersonalizedRecommendationEntity> getAllPersonalziedRecommendations();
    PersonalizedRecommendationEntity createPersonalizedRecommendations(PersonalizedRecoDto personalizedRecoDto);
    PersonalizedRecommendationEntity updatePersonalizedRecommendations(Long id, PersonalizedRecommendationEntity personalizedRecommendationEntity);
    PersonalizedRecommendationEntity deletePersonalizedRecommendations(Long id);
    PersonalizedRecommendationEntity getPersonalizedRecommendationsById(Long id);
}

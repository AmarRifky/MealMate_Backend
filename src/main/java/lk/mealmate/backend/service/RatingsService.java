package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.AddRatingsDto;
import lk.mealmate.backend.entity.RatingsEntity;


@Service
public interface RatingsService {
    List<RatingsEntity> getAllRatings();
    RatingsEntity createRatings(AddRatingsDto addRatingsDto);
    RatingsEntity updateRatings(RatingsEntity ratingsEntity);
    RatingsEntity deleteRatings(Long id);
    RatingsEntity getRatingsById(Long id); 
}

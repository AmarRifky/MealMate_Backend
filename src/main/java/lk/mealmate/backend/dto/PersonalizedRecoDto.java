package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalizedRecoDto {
    private Long recipeId;
    private String recipeName;
    private Long userID;
}
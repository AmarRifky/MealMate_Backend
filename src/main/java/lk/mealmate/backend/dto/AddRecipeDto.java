package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRecipeDto {
    private Long recipeID;
    private String recipeName;
    private Long userID;
    private Long adminId;
    private String instructions;
    private String ingredients;
    private Long rateID;
}

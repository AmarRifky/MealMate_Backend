package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomizedRecipeDto {
    private Long userID;
    private String recipeName;
    private String customInstructions;
    private Long adminId;
}

package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRatingsDto {
    private String rate;
    private Long recipeID;
    private Long userID;
    private Long commentID;
}

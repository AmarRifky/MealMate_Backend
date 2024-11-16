package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsDto {
    private Long userID;
    private Long recipeID;
    private String commentText;
    private Long rateId;
}

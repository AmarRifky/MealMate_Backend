package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityInteractionDto {
    private Long userID;
    private String interactionType;
}

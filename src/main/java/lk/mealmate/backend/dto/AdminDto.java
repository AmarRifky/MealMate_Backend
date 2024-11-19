package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    private String username;
    private String email;
    private String password;
    private Long recipeID;
}

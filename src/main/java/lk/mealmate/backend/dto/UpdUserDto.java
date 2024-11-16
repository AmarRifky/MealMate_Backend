package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdUserDto {
    public UpdUserDto(String userID2, String username2, String email2, String password2) {
        //TODO Auto-generated constructor stub
    }
    private Long userID;
    private String username;
    private String email;
    private String password;
}

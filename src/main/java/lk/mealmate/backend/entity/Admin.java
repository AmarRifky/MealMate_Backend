package lk.mealmate.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin extends UserEntity{

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private RecipeEntity recipeEntity;

}
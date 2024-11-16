package lk.mealmate.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "ratings")
public class RatingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingsId")
    private Long id;

    // @Column(unique = true)
    // private String rateID;

    @Column(unique = true)
    private String rate;

    // @Column(unique = true)
    // private String recipeId;

    // @Column(unique = true)
    // private String userID;

    //relationships

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private RecipeEntity recipeEntity;

    @ManyToOne
    @JoinColumn(name = "commentId")
    private CommentsEntity commentsEntity;
    

}
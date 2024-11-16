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
@Table(name = "admin")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId")
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

    @Column(unique = true)
    private String email;

    // relationships

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private RecipeEntity recipeEntity;

}
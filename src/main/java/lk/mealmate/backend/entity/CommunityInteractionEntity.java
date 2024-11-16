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
@Table(name = "community_interaction")
public class CommunityInteractionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communityInteractionId")
    private Long id;

    // @Column(unique = true)
    // private String userID;

    @Column(unique = true)
    private String interactionType;

    // relationships

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
}
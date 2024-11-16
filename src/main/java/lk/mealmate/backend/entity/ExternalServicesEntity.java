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
@Table(name = "external_services")
public class ExternalServicesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "externalServicesId")
    private Long id;

    @Column(unique = true)
    private String serviceName;

    @Column(unique = true)
    private String serviceType;

    @Column(unique = true)
    private String serviceContact;

    @Column(unique = true)
    private String serviceLocation;

    // relationships

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

}
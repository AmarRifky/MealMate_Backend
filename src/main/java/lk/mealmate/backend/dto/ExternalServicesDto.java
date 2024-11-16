package lk.mealmate.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalServicesDto {
    private String serviceName;
    private String serviceType;
    private String serviceContact;
    private String serviceLocation;
    private Long userID;
}

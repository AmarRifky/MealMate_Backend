package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.ExternalServicesDto;
import lk.mealmate.backend.entity.CustomizedRecipeEntity;
import lk.mealmate.backend.entity.ExternalServicesEntity;


@Service
public interface ExternalServicesService {
    List<ExternalServicesEntity> getallExternalServices();
    ExternalServicesEntity CreateExternalServices(ExternalServicesDto externalServicesDto);
    ExternalServicesEntity getExternalServicesById(Long id);
    ExternalServicesEntity updateExternalService(Long id, CustomizedRecipeEntity customizedRecipeEntity);
    ExternalServicesEntity deleteExternalService(Long id);
}

package lk.mealmate.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.ExternalServicesDto;
import lk.mealmate.backend.entity.CustomizedRecipeEntity;
import lk.mealmate.backend.entity.ExternalServicesEntity;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.ExternalServiceRepository;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.ExternalServicesService;

@Service
public class ExternalServicesServiceImpl implements ExternalServicesService {

    @Autowired
    private ExternalServiceRepository externalServiceRepository;

    @Autowired
    private UserRepository userRepository;

    // Retrieve all external services
    @Override
    public List<ExternalServicesEntity> getallExternalServices() {
        return externalServiceRepository.findAll();
    }

    // Create a new external service
    @Override
    public ExternalServicesEntity CreateExternalServices(ExternalServicesDto externalServicesDto) {
        ExternalServicesEntity entity = new ExternalServicesEntity();
        UserEntity userEntity = userRepository.findById(externalServicesDto.getUserID()).orElse(null);
        entity.setServiceName(externalServicesDto.getServiceName());
        entity.setServiceType(externalServicesDto.getServiceType());
        entity.setServiceContact(externalServicesDto.getServiceContact());
        entity.setServiceLocation(externalServicesDto.getServiceLocation());
        entity.setUserEntity(userEntity);

        return externalServiceRepository.save(entity);
    }

    // Get an external service by its ID
    @Override
    public ExternalServicesEntity getExternalServicesById(Long id) {
        return externalServiceRepository.findById(id)
                .orElseThrow(null);
    }

    // Update an external service by its ID
    @Override
    public ExternalServicesEntity updateExternalService(Long id, CustomizedRecipeEntity customizedRecipeEntity) {
        ExternalServicesEntity existingEntity = externalServiceRepository.findById(id)
                .orElseThrow(null);

        existingEntity.setServiceName(customizedRecipeEntity.getRecipeName()); // Example update, adjust as needed
        existingEntity.setServiceType("Updated Service Type"); // Example update, adjust as needed
        existingEntity.setServiceContact("Updated Contact"); // Example update, adjust as needed
        existingEntity.setServiceLocation("Updated Location"); // Example update, adjust as needed

        // Update the relationship with UserEntity if needed
        existingEntity.setUserEntity(customizedRecipeEntity.getUserEntity());

        return externalServiceRepository.save(existingEntity);
    }

    // Delete an external service by its ID
    @Override
    public ExternalServicesEntity deleteExternalService(Long id) {
        ExternalServicesEntity existingEntity = externalServiceRepository.findById(id)
                .orElseThrow(null);

        externalServiceRepository.delete(existingEntity);
        return existingEntity;
    }

}

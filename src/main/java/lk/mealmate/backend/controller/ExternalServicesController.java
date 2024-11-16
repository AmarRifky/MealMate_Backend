package lk.mealmate.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.mealmate.backend.dto.ExternalServicesDto;
import lk.mealmate.backend.entity.CustomizedRecipeEntity;
import lk.mealmate.backend.entity.ExternalServicesEntity;
import lk.mealmate.backend.service.ExternalServicesService;

@RestController
@RequestMapping("/api/external-services")
@CrossOrigin(origins = "*")
public class ExternalServicesController {
    @Autowired
    private ExternalServicesService externalServicesService;

    /**
     * Retrieves a list of all external services.
     * 
     * @return A list of ExternalServicesEntity objects.
     */
    @GetMapping
    public ResponseEntity<List<ExternalServicesEntity>> getAllExternalServices() {
        List<ExternalServicesEntity> services = externalServicesService.getallExternalServices();
        return ResponseEntity.ok(services);
    }

    /**
     * Retrieves a specific external service by its ID.
     * 
     * @param id The ID of the external service to retrieve.
     * @return The ExternalServicesEntity object with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExternalServicesEntity> getExternalServiceById(@PathVariable Long id) {
        ExternalServicesEntity service = externalServicesService.getExternalServicesById(id);
        return ResponseEntity.ok(service);
    }

    /**
     * Creates a new external service.
     * 
     * @param externalServicesDto Data transfer object containing the details of the
     *                            external service.
     * @return The created ExternalServicesEntity object.
     */
    @PostMapping
    public ResponseEntity<ExternalServicesEntity> createExternalService(
            @RequestBody ExternalServicesDto externalServicesDto) {
        ExternalServicesEntity newService = externalServicesService.CreateExternalServices(externalServicesDto);
        return ResponseEntity.ok(newService);
    }

    /**
     * Updates an existing external service by its ID.
     * 
     * @param id                  The ID of the external service to update.
     * @param externalServicesDto The updated ExternalServicesDto object.
     * @return The updated ExternalServicesEntity object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ExternalServicesEntity> updateExternalService(@PathVariable Long id,
            @RequestBody ExternalServicesDto externalServicesDto) {
        // Create a CustomizedRecipeEntity from ExternalServicesDto (assuming the update
        // logic in service)
        CustomizedRecipeEntity customizedRecipeEntity = new CustomizedRecipeEntity();
        customizedRecipeEntity.setRecipeName(externalServicesDto.getServiceName());
        // Set other fields as needed

        ExternalServicesEntity updatedService = externalServicesService.updateExternalService(id,
                customizedRecipeEntity);
        return ResponseEntity.ok(updatedService);
    }

    /**
     * Deletes a specific external service by its ID.
     * 
     * @param id The ID of the external service to delete.
     * @return The deleted ExternalServicesEntity object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ExternalServicesEntity> deleteExternalService(@PathVariable Long id) {
        ExternalServicesEntity deletedService = externalServicesService.deleteExternalService(id);
        return ResponseEntity.ok(deletedService);
    }
}

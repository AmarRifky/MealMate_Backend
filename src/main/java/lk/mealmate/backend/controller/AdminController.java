package lk.mealmate.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lk.mealmate.backend.dto.UserPwdDto;
import lk.mealmate.backend.entity.AdminEntity;
import lk.mealmate.backend.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * Retrieves all admin entities.
     * @return List of AdminEntity.
     */
    @GetMapping("/admins")
    public List<AdminEntity> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    /**
     * Creates a new admin entity.
     * @param adminEntity Admin details to create.
     * @return The created AdminEntity.
     */
    @PostMapping("/admins")
    public AdminEntity createAdmin(@RequestBody AdminEntity adminEntity){
        return adminService.createAdmin(adminEntity);
    }

    /**
     * Retrieves an admin entity by its ID.
     * @param id ID of the admin entity to retrieve.
     * @return The AdminEntity if found, or null if not.
     */
    @GetMapping("/admins/{id}")
    public AdminEntity getAdminById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }

    /**
     * Updates the password for the admin entity with the specified ID.
     * @param id ID of the admin entity whose password is to be changed.
     * @param userPwdDto DTO containing the new password.
     * @return The updated AdminEntity with the new password.
     */
    @PutMapping("/admins/{id}/change-password")
    public ResponseEntity<AdminEntity> changeUserPassword(@PathVariable Long id, @RequestBody UserPwdDto userPwdDto){
        AdminEntity updatedAdmin = adminService.changeUserPassword(id, userPwdDto);
        return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.badRequest().build();
    }
}

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

import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return a list of UserEntity objects.
     */
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user.
     * @return The UserEntity object corresponding to the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getAllUsersById(id));
    }

    /**
     * Creates a new user.
     *
     * @param updUserDto The user details for creation.
     * @return The created UserEntity object.
     */
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity updUserDto) {
        return ResponseEntity.ok(userService.createUser(updUserDto));
    }

    /**
     * Updates an existing user.
     *
     * @param userEntity The updated user details.
     * @return The updated UserEntity object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.updateUser(userEntity));
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user.
     * @return The deleted UserEntity object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}

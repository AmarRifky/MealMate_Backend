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

import lk.mealmate.backend.entity.User;
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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user.
     * @return The UserEntity object corresponding to the given ID.
     */
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getAllUserById(id);
    }

    /**
     * Creates a new user.
     *
     * @param updUserDto The user details for creation.
     * @return The created UserEntity object.
     */
    @PostMapping
    public UserEntity createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    /**
     * Updates an existing user.
     *
     * @param userEntity The updated user details.
     * @return The updated UserEntity object.
     */
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
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

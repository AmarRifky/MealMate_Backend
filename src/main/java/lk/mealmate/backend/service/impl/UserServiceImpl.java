package lk.mealmate.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves all users from the repository.
     * @return List of UserEntity.
     */
    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Creates a new user based on the provided DTO.
     * @param updUserDto Data Transfer Object containing user details.
     * @return Created UserEntity.
     */
    @Override
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity user = new UserEntity();
        user.setUsername(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());

        return userRepository.save(userEntity);
    }

    /**
     * Updates an existing user.
     * @param userEntity The user entity with updated information.
     * @return Updated UserEntity, or null if the user was not found.
     */
    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        if (userRepository.existsById(userEntity.getId())) {
            return userRepository.save(userEntity);
        }
        return null; // Or throw an exception if preferred
    }

    /**
     * Deletes a user by its ID.
     * @param id ID of the user to delete.
     * @return Deleted UserEntity, or null if not found.
     */
    @Override
    public UserEntity deleteUser(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userRepository.delete(userEntity);
            return userEntity;
        }
        return null; // Or throw an exception if preferred
    }

    /**
     * Retrieves a user by its ID.
     * @param id ID of the user to retrieve.
     * @return UserEntity if found, otherwise null.
     */
    @Override
    public UserEntity getAllUsersById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}

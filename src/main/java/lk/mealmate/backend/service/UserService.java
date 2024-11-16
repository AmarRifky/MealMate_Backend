package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.entity.UserEntity;


@Service
public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity userEntity);
    UserEntity deleteUser(Long id);
    UserEntity getAllUsersById(Long id);
}

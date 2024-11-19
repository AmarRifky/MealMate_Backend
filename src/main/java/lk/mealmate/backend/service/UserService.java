package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.entity.Admin;
import lk.mealmate.backend.entity.User;
import lk.mealmate.backend.entity.UserEntity;


@Service
public interface UserService {
    List<User> getAllUsers();
    UserEntity createUser(User user);
    UserEntity updateUser(Long id, User user);
    UserEntity deleteUser(Long id);
    UserEntity getAllUserById(Long id);
    List<Admin> getAllAdmins();
    UserEntity createAdmin(Admin admin);
    UserEntity updateAdmin(Long id, Admin admin);
    UserEntity deleteAdmin(Long id);
}

package lk.mealmate.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.entity.Admin;
import lk.mealmate.backend.entity.User;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.entity.UserRole;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createAdmin(Admin admin) {
        Admin newAdmin = new Admin();
        newAdmin.setEmail(admin.getEmail());
        newAdmin.setUsername(admin.getUsername());
        newAdmin.setPassword(passwordEncoder.encode(admin.getPassword()));
        newAdmin.setRole(UserRole.ADMIN);
        return userRepository.save(newAdmin);
    }

    @Override
    public UserEntity createUser(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(UserRole.USER);
        return userRepository.save(newUser);
    }

    @Override
    public UserEntity deleteAdmin(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity!=null) {
            userRepository.delete(userEntity);
            return userEntity;
        } else {
            return null;
        }
    }

    @Override
    public UserEntity deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity!=null) {
            userRepository.delete(userEntity);
            return userEntity;
        } else {
            return null;
        }
    }

    @Override
    public List<Admin> getAllAdmins() {
        return userRepository.findAdminsByRole(UserRole.ADMIN);
    }

    @Override
    public UserEntity getAllUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findUsersByRole(UserRole.USER);
    }

    @Override
    public UserEntity updateAdmin(Long id, Admin admin) {
        UserEntity existingAdmin = userRepository.findById(id).orElse(null);
        if (existingAdmin!=null && existingAdmin instanceof Admin) {
            Admin admin2 = (Admin) existingAdmin;
            admin2.setUsername(admin.getUsername());
            admin2.setEmail(admin.getEmail());
            return userRepository.save(admin2);
        } else {
            return null;
        }
    }

    @Override
    public UserEntity updateUser(Long id, User user) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser!=null && existingUser instanceof User) {
            User user2 = (User) existingUser;
            user2.setUsername(user.getUsername());
            user2.setEmail(user.getEmail());
            return userRepository.save(user2);
        } else {
            return null;
        }
    }

}

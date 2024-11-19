package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.UserPwdDto;
import lk.mealmate.backend.entity.Admin;

@Service
public interface AdminService {
    Admin createAdmin(Admin adminEntity);
    Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    Admin changeUserPassword(Long id, UserPwdDto userPwdDto);
}

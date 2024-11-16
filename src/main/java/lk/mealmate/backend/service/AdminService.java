package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.UserPwdDto;
import lk.mealmate.backend.entity.AdminEntity;

@Service
public interface AdminService {
    AdminEntity createAdmin(AdminEntity adminEntity);
    AdminEntity getAdminById(Long id);
    List<AdminEntity> getAllAdmins();
    AdminEntity changeUserPassword(Long id, UserPwdDto userPwdDto);
}

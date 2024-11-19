package lk.mealmate.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lk.mealmate.backend.dto.AuthResponse;
import lk.mealmate.backend.dto.LoginDto;
import lk.mealmate.backend.entity.Admin;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.security.UserDetailsImpl;
import lk.mealmate.backend.security.jwt.JwtUtils;
import lk.mealmate.backend.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class AdminAuthController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/auth/admin/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = userDetails.getId();
        return ResponseEntity.ok().body(new AuthResponse(token, userId));
    }

    @PostMapping("/auth/admin/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {

        if (userRepository.existsByUsername(admin.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }

        if (userRepository.existsByEmail(admin.getEmail())) {
            return ResponseEntity.badRequest().body("This email is being used");
        }

        return ResponseEntity.ok(userService.createAdmin(admin));
    }
}

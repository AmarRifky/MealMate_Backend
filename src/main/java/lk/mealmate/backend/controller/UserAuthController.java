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

import lk.mealmate.backend.dto.LoginDto;
import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.UserRepository;
import lk.mealmate.backend.security.jwt.JwtUtils;
import lk.mealmate.backend.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserAuthController {
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
    
    @PostMapping("/auth/user/login") 
    public ResponseEntity<?> login(@RequestBody LoginDto loginDTO) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/auth/user/register")
    public ResponseEntity<?> register(@RequestBody UserEntity userEntity) {
        
        if(userRepository.existsByUsername(userEntity.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }

        if(userRepository.existsByEmail(userEntity.getEmail())) {
            return ResponseEntity.badRequest().body("This email is being used");
        }

        UserEntity newUser = new UserEntity();
        newUser.setUsername(userEntity.getUsername());
        newUser.setEmail(userEntity.getEmail());
        newUser.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        return ResponseEntity.ok(userService.createUser(newUser));
    }
}

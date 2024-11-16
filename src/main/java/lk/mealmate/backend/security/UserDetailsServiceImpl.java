package lk.mealmate.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lk.mealmate.backend.entity.UserEntity;
import lk.mealmate.backend.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);

        if( userEntity == null ) {
            throw new UsernameNotFoundException("User is not found with the username");
        }

        return org.springframework.security.core.userdetails.User.builder()
            .username(userEntity.getUsername())
            .password(userEntity.getPassword())
            .build();
    }
}

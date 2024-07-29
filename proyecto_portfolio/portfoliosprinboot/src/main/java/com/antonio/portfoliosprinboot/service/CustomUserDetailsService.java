package com.antonio.portfoliosprinboot.service;
import com.antonio.portfoliosprinboot.repository.UserRepository;
import java.util.Optional;
import com.antonio.portfoliosprinboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        User user = optionalUser.get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
            Arrays.stream(user.getRoles().split(","))
                  .map(SimpleGrantedAuthority::new)
                  .collect(Collectors.toList()));
    }
}


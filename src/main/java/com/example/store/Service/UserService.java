package com.example.store.Service;

import com.example.store.Model.User;
import com.example.store.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.management.relation.Role;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
     private  final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;

     public ResponseEntity<List<User>> getAllUsers(){
         return userRepository.findAll();
     }
     public ResponseEntity<User> getUserById(@PathVariable Long id){


     }

     public User createUser(User user){
         if (userRepository.existsByEmail(user.getEmail())){
             throw new RuntimeException("Email already exists");
         }
         user.setPassword(passwordEncoder.encode(user.getEmail()));
         user.setRole(Role.USER);

         return userRepository.save(user);
     }
}

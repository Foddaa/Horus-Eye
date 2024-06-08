package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserToken;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Boolean check(String email){
        if(getByEmail(email).isPresent()){
            return false;
        }
        else return true;
    }
    public Optional<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public ResponseEntity<String> updateUser(User user){
        userRepository.save(user);
        return ResponseEntity.ok("user created successfully");
    }
    public ResponseEntity<Boolean> confirmPassword(UserToken userToken,String password){
        User user =new User(userToken.getEmail(),userToken.getFirstName(),userToken.getLastName(),password,userToken.getBirthDate(),userToken.getCountry(),userToken.getPhoneNumber());
        userRepository.save(user);
            return ResponseEntity.ok(true);
    }
    public ResponseEntity<String> login(String email,String password){
        Optional<User> user =userRepository.findByEmail(email);
        if (user.isPresent() ){
            if (user.get().getPassword().equals(password)){
                return ResponseEntity.ok("1");
            }
            return ResponseEntity.ok("wrong password");
        }
        return ResponseEntity.ok("email not found");
    }
    public ResponseEntity<String> deleteUser(String email){
        if (userRepository.findByEmail(email).isEmpty()){
            return ResponseEntity.ok("user not found");
        }
        userRepository.deleteByEmail(email);
        return ResponseEntity.ok("user deleted successfully");
    }
}

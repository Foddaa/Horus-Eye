package com.example.demo.service;

import com.example.demo.model.User;
//import com.example.demo.model.UserToken;
import com.example.demo.model.UserToken;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Boolean check(String email){
        if(getByEmail(email).isPresent()){
            return true;
        }
        else return false;
    }
    public Optional<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
    public ResponseEntity<String> login(String email,String password){
        Optional<User> user =userRepository.findByEmail(email);
        if (user.isPresent() ){
            if (user.get().getPassword().equals(password)){
                return ResponseEntity.ok("login successful");
            }
            return ResponseEntity.ok("password incorrect");
        }
        return ResponseEntity.ok("user not found");
    }
    public ResponseEntity<String> signUp( User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.ok("user already exists");
        }
        user.setPassport("Still Empty");
        saveUser(user);
        return ResponseEntity.ok("user created successfully");
    }

    public ResponseEntity<String> updateUser(User user){
        if (userRepository.findByEmail(user.getEmail()).isEmpty()){
            return ResponseEntity.ok("user not found");
        }
        if (user.getPassport() == null){
            user.setPassport(userRepository.findByEmail(user.getEmail()).get().getPassport());
        }
        userRepository.save(user);
        return ResponseEntity.ok("user updated successfully");
    }
    public ResponseEntity<String> uploadImage(MultipartFile file,String email) throws IOException {
        User user =userRepository.findByEmail(email).get();
        String directory = System.getProperty("user.dir")+"\\images\\";
        String filePath = directory + user.getEmail()+".png";
        file.transferTo(new File(filePath));
        user.setPassport(filePath);
        userRepository.save(user);
        return ResponseEntity.ok("image uploaded successfully");
    }
    public ResponseEntity<String> deleteUser(String email){
        if (userRepository.findByEmail(email).isEmpty()){
            return ResponseEntity.ok("user not found");
        }
        userRepository.deleteByEmail(email);
        return ResponseEntity.ok("user deleted successfully");
    }
}

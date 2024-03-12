package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping(value= "/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("role") String role) throws IOException {
        User user = new User(email,firstName,lastName,password,role,"");
        return userService.signUp(file,user);

    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("email") String email, @RequestParam("password") String password){
        return userService.login(email,password);
    }
    @PostMapping("test")
    public ResponseEntity<String> signUp(@RequestBody MultipartFile file,@RequestBody User user) throws IOException {
        return ResponseEntity.ok("File uploaded successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @PutMapping(value = "/uploadImage", consumes = "multipart/form-data")
    public ResponseEntity<String> updateUserImage(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) throws IOException {
        return userService.uploadImage(file,email);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam("email") String email){
        return userService.deleteUser(email);
    }



}
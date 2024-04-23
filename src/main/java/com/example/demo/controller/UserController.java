package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserToken;
import com.example.demo.service.UserService;
import com.example.demo.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;
    @Autowired
    UserTokenService userTokenService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
    @PostMapping("/newToken")
    public void newToken(@RequestBody UserToken userToken){
        userTokenService.createToken(userToken);
    }
    @GetMapping("/assignCode")
    public ResponseEntity<String> assignCode(@RequestParam("email") String email, @RequestParam("code") String code){
        return userTokenService.verify(email,code);
    }
    @PostMapping("/signUpInformation")
    public ResponseEntity<String>signUpInformation(@RequestBody User user){
        return userService.signUp(user);
    }
    @GetMapping("/check")
    public boolean check(String email){
        return userService.check(email);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("email") String email, @RequestParam("password") String password){
        return userService.login(email,password);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) throws IOException {
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

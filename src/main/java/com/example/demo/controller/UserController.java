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
    public int newToken(@RequestBody UserToken userToken){
        try {
            if (userService.check(userToken.getEmail())) {
                userTokenService.createToken(userToken);
                return 1;
            }
            else {
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    @PostMapping("/confirmPassword")
    public ResponseEntity<Boolean> confirmPassword(@RequestParam("email") String email, @RequestParam("password") String password){
        UserToken userToken= userTokenService.confirmPassword(email);
        return userService.confirmPassword(userToken,password);
    }
    @PostMapping("/assignCode")
    public Boolean assignCode(@RequestParam("email") String email, @RequestParam("code") String code){
        return userTokenService.checkCode(email,code);
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
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam("email") String email){
        return userService.deleteUser(email);
    }



}

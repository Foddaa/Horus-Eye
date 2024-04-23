package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserToken;
import com.example.demo.repository.UserTokenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Service
public class UserTokenService {
    @Autowired
    UserService userService;
    @Autowired
    UserTokenRepository userTokenRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Scheduled(fixedDelay = 60 * 60 * 1000) // Run every 24 hours
    public void deleteExpiredEntities() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expirationTime = now.minus(1, ChronoUnit.HOURS);
        List<UserToken> expiredEntities=userTokenRepository.findByCreationTimeBefore(expirationTime);
        userTokenRepository.deleteAll(expiredEntities);

    }
    public String sendCode(String receiver){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("eyehorus458@gmail.com");
        message.setTo(receiver);
        message.setSubject("verification code");
        Random random = new Random();
        int code0 = 100000 + random.nextInt(900000);
        String code =String.valueOf(code0);
        message.setText("your code is '"+code+"'");
        javaMailSender.send(message);
        return code;
    }
    public void createToken(UserToken userToken){
        userToken.setCode(sendCode(userToken.getEmail()));
        userToken.setCreationTime(LocalDateTime.now());
        userTokenRepository.save(userToken);
    }
    public boolean checkCode(String email,String code){
        UserToken userToken=userTokenRepository.findByEmail(email);
        if (userToken.getCode().equals(code)){
            return true;
        }
        return false;
    }
    @Transactional
    public void deleteToken(String email){
        userTokenRepository.deleteByEmail(email);
    }
    @Transactional
    public ResponseEntity<String> verify(String email,String code){
        if (checkCode(email,code)){
            UserToken userToken=userTokenRepository.findByEmail(email);
            User user=new User(userToken.getEmail(),userToken.getFirstName(),userToken.getLastName(),userToken.getPassword(),userToken.getRole(),userToken.getPhoneNumber(),userToken.getBirthDate(),"");
            userService.saveUser(user);
            deleteToken(email);
            return ResponseEntity.ok("you are verified");
        }
        return ResponseEntity.ok("code incorrect");
    }
}

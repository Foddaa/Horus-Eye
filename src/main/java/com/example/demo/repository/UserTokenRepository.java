package com.example.demo.repository;

import com.example.demo.model.UserToken;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,String> {
    List<UserToken> findByCreationTimeBefore(LocalDateTime expirationTime);

    UserToken findByEmail(String email);
    @Modifying
    @Transactional
    void deleteByEmail(@Param("val") String email);

}

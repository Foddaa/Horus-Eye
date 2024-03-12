package com.example.demo.repository;

import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT s FROM User s where email=:val")
    Optional<User> findByEmail(@Param("val") String email);
    @Query(value = "DELETE FROM User s where (email=:val)")
    @Modifying
    @Transactional
    void deleteByEmail(@Param("val") String email);


}

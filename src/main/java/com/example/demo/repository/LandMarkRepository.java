package com.example.demo.repository;

import com.example.demo.model.LandMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandMarkRepository extends JpaRepository<LandMark, Integer> {
    List<LandMark> findByNameContaining(String name);

}

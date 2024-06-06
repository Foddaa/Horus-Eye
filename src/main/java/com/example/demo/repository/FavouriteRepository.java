package com.example.demo.repository;

import com.example.demo.model.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourites, Integer> {

    List<Favourites> findAllByUserEmail(String email);
}

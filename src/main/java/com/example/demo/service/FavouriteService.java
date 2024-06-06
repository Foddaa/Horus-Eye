package com.example.demo.service;

import com.example.demo.model.FavoriteLandmarks;
import com.example.demo.model.Favourites;
import com.example.demo.model.LandMark;
import com.example.demo.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteService {
    @Autowired
    FavouriteRepository favouriteRepository;
    @Autowired
    LandMarkService landMarkService;
    public List<FavoriteLandmarks> gitAllFavourites(String email) {
        List<Favourites> list = favouriteRepository.findAllByUserEmail(email);
        List<FavoriteLandmarks> list2 = new ArrayList<>();
        for(Favourites favourites : list){
            LandMark landMark = landMarkService.getLandMarkById(favourites.getLandMarkId());
            FavoriteLandmarks favoriteLandmarks = new FavoriteLandmarks();
            favoriteLandmarks.setName(landMark.getName());
            favoriteLandmarks.setDescription(landMark.getDescription());
            favoriteLandmarks.setLocation(landMark.getLocation());
            favoriteLandmarks.setImage(landMark.getImage());
            favoriteLandmarks.setFID(favourites.getId());
            favoriteLandmarks.setId(favourites.getLandMarkId());
            list2.add(favoriteLandmarks);
        }
        return list2;
    }
    public void removeFromFavourites(int id) {
        favouriteRepository.deleteById(id);
    }
    public void add(Favourites favourites) {
        List<FavoriteLandmarks> list = gitAllFavourites(favourites.getUserEmail());
        for(FavoriteLandmarks favoriteLandmarks : list){
            if(favoriteLandmarks.getId() == favourites.getLandMarkId()){
                return;
            }
        }
        favouriteRepository.save(favourites);
    }
}

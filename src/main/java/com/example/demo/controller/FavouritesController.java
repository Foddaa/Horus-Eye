package com.example.demo.controller;

import com.example.demo.model.FavoriteLandmarks;
import com.example.demo.model.Favourites;
import com.example.demo.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourite")
public class FavouritesController {
    @Autowired
    FavouriteService favouriteService;
    @GetMapping("/all")
    public List<FavoriteLandmarks> getAll(@RequestParam String email) {
        return favouriteService.gitAllFavourites(email);
    }

    @PostMapping("/remove")
    public void removeFromFavourites(@RequestParam int id) {
        favouriteService.removeFromFavourites(id);
    }


    @PostMapping("/add")
    public void addToFavourites(@RequestBody Favourites favourites) {
        favouriteService.add(favourites);
    }
}

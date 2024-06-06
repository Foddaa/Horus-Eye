package com.example.demo.model;

import lombok.Data;

public class FavoriteLandmarks extends LandMark {
    private int FID;


    public void setFID(int fID){
        this.FID = fID;
    }


    public int getFID(){
        return this.FID;
    }

}






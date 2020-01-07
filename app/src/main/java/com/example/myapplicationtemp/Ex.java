package com.example.myapplicationtemp;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class Ex {
    private String numberEx;
    private ArrayList<Image>  image;

    public Ex(String noex,String nopage, ArrayList<Image>  images) {

        this.numberEx = noex;
        this.image = new ArrayList<Image>(images);


    }
    public Ex(String noex,String nopage){
        this.numberEx = noex;
    }
    public String getNumber() {
        return numberEx;
    }

    public void setNumber(String number) {
        this.numberEx = number;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(ArrayList<Image> image) {
        this.image = image;
    }


}
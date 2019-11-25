package com.example.restaurantapp.Model;


import com.google.gson.annotations.SerializedName;

public class Drink {


    @SerializedName("strDrink")
    String name;
    @SerializedName("strDrinkThumb")
    String image;

    @SerializedName("IdDrink")
    int id;


    public Drink(String name, String image,int id)
    {
        this.image=image;
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}

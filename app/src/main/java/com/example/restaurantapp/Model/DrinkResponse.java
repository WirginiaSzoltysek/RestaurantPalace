package com.example.restaurantapp.Model;


import com.example.restaurantapp.Model.Drink;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;

public class DrinkResponse {



    @SerializedName("drinks")
    private ArrayList<Drink> drinkList;



    public Drink getDrink() {

        return new Drink(drinkList.get(0).getName(),
                drinkList.get(0).getImage(),drinkList.get(0).getId());

    }



}

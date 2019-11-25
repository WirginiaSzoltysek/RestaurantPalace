package com.example.restaurantapp;

import com.example.restaurantapp.Model.DrinkAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://thecocktaildb.com/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static DrinkAPI drinkApi = retrofit.create(DrinkAPI.class);

    public static DrinkAPI getDrinkApi() {
        return drinkApi;
    }


}

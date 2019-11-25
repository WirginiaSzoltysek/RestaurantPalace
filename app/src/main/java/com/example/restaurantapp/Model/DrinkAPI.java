package com.example.restaurantapp.Model;

import com.example.restaurantapp.Model.DrinkResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface DrinkAPI {

    @GET("api/json/v1/1/search.php")
    Call<DrinkResponse> getDrink(@Query("s") String name);


}

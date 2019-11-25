package com.example.restaurantapp.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.restaurantapp.Model.Drink;
import com.example.restaurantapp.Model.DrinkAPI;
import com.example.restaurantapp.Model.DrinkResponse;
import com.example.restaurantapp.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkRepository {


    private static DrinkRepository instance;
    private MutableLiveData<Drink> drink;

    private DrinkRepository() {
        drink = new MutableLiveData<>();
    }


    public static synchronized DrinkRepository getInstance() {
        if (instance == null) {
            instance = new DrinkRepository();
        }
        return instance;

    }

    public LiveData<Drink> getDrink() {
        return drink;
    }

    public void updateDrink(String drinkName) {
        DrinkAPI drinkApi = ServiceGenerator.getDrinkApi();
        Call<DrinkResponse> call = drinkApi.getDrink(drinkName);
        call.enqueue(new Callback<DrinkResponse>() {
            @Override
            public void onResponse(Call<DrinkResponse> call, Response<DrinkResponse> response) {

                if (response.code() == 200) {
                    drink.setValue(response.body().getDrink());
            }

            }

            @Override
            public void onFailure(Call<DrinkResponse> call, Throwable t) {
                    Log.i("Retrofit", "Something went wrong :(");
                }

        });


        }
}

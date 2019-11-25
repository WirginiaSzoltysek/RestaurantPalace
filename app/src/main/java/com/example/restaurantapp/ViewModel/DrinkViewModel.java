package com.example.restaurantapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.restaurantapp.Model.Drink;
import com.example.restaurantapp.Repository.DrinkRepository;

public class DrinkViewModel extends ViewModel {


    DrinkRepository rep;

    public DrinkViewModel(){

        rep= DrinkRepository.getInstance();
    }

    public LiveData<Drink> getDrink()
    {
        return rep.getDrink();
    }


    public void updateDrink(String s){
        rep.updateDrink(s);
    }
}

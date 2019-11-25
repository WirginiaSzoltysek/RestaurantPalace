package com.example.restaurantapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.restaurantapp.Model.Meal;
import com.example.restaurantapp.Repository.MealRepository;

import java.util.List;

public class MealViewModel extends AndroidViewModel {

    private LiveData<List<Meal>> liveMeals;
    private MealRepository mealRep;

    public MealViewModel(@NonNull Application application) {
        super(application);
        mealRep = new MealRepository(application);
        liveMeals= mealRep.getLiveMeals();
    }

    public void insert(Meal meal) {
        mealRep.insert(meal);
    }
    public LiveData<List<Meal>> getLiveMeals() {
        return liveMeals;
    }



}

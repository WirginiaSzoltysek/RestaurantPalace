package com.example.restaurantapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.restaurantapp.Model.Meal;

import java.util.List;

import retrofit2.http.DELETE;

@Dao
public interface MealsDAO {


        @Insert
        void insert(Meal meal);

        @Query("Select*FROM meal_table ORDER BY name DESC")
        LiveData<List<Meal>> getLiveMeals();
    }


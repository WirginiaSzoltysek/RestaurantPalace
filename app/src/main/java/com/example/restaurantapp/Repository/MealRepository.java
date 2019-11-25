package com.example.restaurantapp.Repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.example.restaurantapp.MealDatabase;
import com.example.restaurantapp.MealsDAO;
import com.example.restaurantapp.Model.Meal;

import java.util.List;

public class MealRepository {

 private MealsDAO mealDao;
 private LiveData<List<Meal>> repMeals;


 public MealRepository(Context context){

     MealDatabase database = MealDatabase.getInstance(context);
     mealDao = database.mealDao();
     repMeals=mealDao.getLiveMeals();
 }

 public void insert(Meal meal){
     new InsertMealAsyncTask(mealDao).execute(meal);

 }
public LiveData<List<Meal>> getLiveMeals(){

      return repMeals;
    }

    private static class InsertMealAsyncTask extends AsyncTask<Meal,Void,Void>{

     private MealsDAO mealsDAO;
     private InsertMealAsyncTask(MealsDAO mealsDAO){
         this.mealsDAO=mealsDAO;
     }
        @Override
        protected Void doInBackground(Meal... meals) {
         mealsDAO.insert(meals[0]);
            return null;
        }
    }




}

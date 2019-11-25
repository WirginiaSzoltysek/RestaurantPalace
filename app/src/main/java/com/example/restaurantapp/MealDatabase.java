package com.example.restaurantapp;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.restaurantapp.Model.Meal;

import static okhttp3.internal.Internal.instance;

@Database(entities = {Meal.class}, version = 1,exportSchema = false)

public abstract class MealDatabase extends RoomDatabase {

        private static MealDatabase instance;
        public abstract MealsDAO  mealDao();

        public static synchronized MealDatabase getInstance(Context context){
            if(instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        MealDatabase.class, "meal_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build();
            }
            return instance;
        }
        private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                new PopulateDbAsyncTask(instance).execute();
            }
        };

        private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
            private MealsDAO mealsDAO;
            private  PopulateDbAsyncTask(MealDatabase db){
                mealsDAO = db.mealDao();
            }
            @Override
            protected Void doInBackground(Void... voids) {
                mealsDAO.insert(new Meal(" Biryani","80 kr",R.drawable.biryani));
                mealsDAO.insert(new Meal("Samosa","60 kr", R.drawable.samosa));
                mealsDAO.insert(new Meal("Thali","100 kr",R.drawable.thali ));
                mealsDAO.insert(new Meal("Butter Chicken","80 kr",R.drawable.butter_chicken2));
                return null;
            }
        }
    }



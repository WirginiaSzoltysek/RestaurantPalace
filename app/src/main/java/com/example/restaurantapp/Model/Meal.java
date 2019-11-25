package com.example.restaurantapp.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName= "meal_table")
public class Meal {


    @PrimaryKey(autoGenerate=true)
    private int mealId;
    private String name;
    private String price;
    private int picture;


    public Meal(String name, String price, int picture) {
        this.name = name;
        this.price = price;
        this.picture = picture;
    }




    public String getName()
    {
        return name;
    }
    public String getPrice(){ return price;}
    public int getPicture()
    {
        return picture;
    }
    public void setId(int mealId)
        {
   this.mealId=mealId;
        }

    public int getId() {
        return mealId;}


}

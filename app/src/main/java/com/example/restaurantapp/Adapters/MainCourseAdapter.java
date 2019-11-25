package com.example.restaurantapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.MainCourseFragment;
import com.example.restaurantapp.Model.Meal;
import com.example.restaurantapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainCourseAdapter extends RecyclerView.Adapter<MainCourseAdapter.ViewHolder> {

    private List<Meal> meals;



    public MainCourseAdapter(List<Meal> mainMeals){
        meals = mainMeals;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.main_course_fragment, parent, false);
        return new ViewHolder(view);

    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {

           viewHolder.text.setText(meals.get(position).getName());
           viewHolder.image.setImageResource(meals.get(position).getPicture());
           viewHolder.price.setText((meals.get(position).getPrice()));

    }

    public int getItemCount()
    {
        return meals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;
        TextView price;
        ViewHolder(View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.meal_name);
            image = itemView.findViewById(R.id.meal_pic);
            price = itemView.findViewById(R.id.meal_price);

        }
    }


}



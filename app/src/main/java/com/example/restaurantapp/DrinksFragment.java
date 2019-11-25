package com.example.restaurantapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.bumptech.glide.Glide;
import com.example.restaurantapp.Model.Drink;
import com.example.restaurantapp.ViewModel.DrinkViewModel;


public class DrinksFragment extends Fragment  {


    DrinkViewModel vModel;
    EditText edit;
    ImageView img;
    Button search_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drinks_fragment,container,false);



        img = view.findViewById(R.id.imageView4);
        edit = view.findViewById(R.id.editText2);
        search_button = view.findViewById(R.id.search_button);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDrink();
            }
        });

        vModel = ViewModelProviders.of(this).get(DrinkViewModel.class);
        vModel.getDrink().observe(this, new Observer<Drink>() {
            @Override
            public void onChanged(Drink drink) {
                Toast.makeText(getContext(), drink.getImage(), Toast.LENGTH_SHORT).show();
                Glide.with(DrinksFragment.this).load(drink.getImage()).into(img);
            }
        });



        return view;
    }




    public void updateDrink(){
        vModel.updateDrink(edit.getText().toString());

    }

}



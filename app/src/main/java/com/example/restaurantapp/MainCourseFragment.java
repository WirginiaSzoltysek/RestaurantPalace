package com.example.restaurantapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Adapters.MainCourseAdapter;
import com.example.restaurantapp.Model.Meal;
import com.example.restaurantapp.ViewModel.MealViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainCourseFragment extends Fragment {



    private RecyclerView mainCourseList;
    private RecyclerView.Adapter mainCourseListAdapter;
    private MealViewModel mealViewModel;
    private    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_course_fragment, container, false);


        Context context = inflater.getContext();
        mainCourseList = view.findViewById(R.id.listMain);
        mainCourseList.hasFixedSize();
        mainCourseList.setLayoutManager(new LinearLayoutManager(getContext()));

        mealViewModel= ViewModelProviders.of(this).get(MealViewModel.class);
        mealViewModel.getLiveMeals().observe(this, new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                mainCourseListAdapter.notifyDataSetChanged();
            }
        });

      initRecyclerView();
      return view;
    }

    private void initRecyclerView() {
        mainCourseListAdapter = new MainCourseAdapter( mealViewModel.getLiveMeals().getValue());
        mainCourseList.setAdapter(mainCourseListAdapter);
        mainCourseList.hasFixedSize();
        mainCourseList.setLayoutManager(new LinearLayoutManager(getContext()));


    }
}

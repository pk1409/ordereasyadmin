package com.oeasy.ordereasyadmin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WaiterLayoutClicked extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<WaiterFoodItems> FoodList=new ArrayList<>();
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter_layout_clicked);
        recyclerView=(RecyclerView) findViewById(R.id.food_recycler_view);
        foodAdapter=new FoodAdapter(FoodList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(foodAdapter);

        prepareFoodData();
    }
    private void prepareFoodData(){
        WaiterFoodItems foodItems=new WaiterFoodItems("Paneer Makhni",16);
        FoodList.add(foodItems);
        foodItems=new WaiterFoodItems("chicken Lawabdar",1);
        FoodList.add(foodItems);
        foodItems=new WaiterFoodItems("baby corn",3);
        FoodList.add(foodItems);
        foodItems=new WaiterFoodItems("chicken chilli",2);
        FoodList.add(foodItems);
        foodItems=new WaiterFoodItems("aalooo",8);
        FoodList.add(foodItems);
        foodItems=new WaiterFoodItems("ghoomar",6);
        FoodList.add(foodItems);
        foodAdapter.notifyDataSetChanged();


    }
}

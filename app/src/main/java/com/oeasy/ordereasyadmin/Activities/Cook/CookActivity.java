package com.oeasy.ordereasyadmin.Activities.Cook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oeasy.ordereasyadmin.Adapter.CookAdapter;
import com.oeasy.ordereasyadmin.Modal.CookItems;
import com.oeasy.ordereasyadmin.R;

import java.util.ArrayList;
import java.util.List;

public class CookActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<CookItems> FoodList=new ArrayList<>();
    private CookAdapter cookAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_details);
        recyclerView=(RecyclerView) findViewById(R.id.food_recycler_view);
        cookAdapter=new CookAdapter(prepareFoodData());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cookAdapter);
        cookAdapter.notifyDataSetChanged();
        prepareFoodData();
    }
    private ArrayList<CookItems> prepareFoodData(){
        CookItems foodItems=new CookItems("Paneer Makhni",16,1,"Kumar Naman");
        FoodList.add(foodItems);
        foodItems=new CookItems("paneer mas",19,3,"Kumar Naman");
        FoodList.add(foodItems);
        foodItems=new CookItems("fgh",1,9,"Kumar Naman");
        FoodList.add(foodItems);
        foodItems=new CookItems("dhdlii",6,5,"Kumar Naman");
        FoodList.add(foodItems);
        foodItems=new CookItems("dlkjdlj",77,4,"Kumar Naman");
        FoodList.add(foodItems);
        foodItems=new CookItems("ddd",2,8,"Kumar Naman");
        FoodList.add(foodItems);
        foodItems=new CookItems("djd",17,11,"Kumar Naman");
        FoodList.add(foodItems);
        return FoodList;
    }
}

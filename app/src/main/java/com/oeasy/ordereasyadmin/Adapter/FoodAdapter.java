package com.oeasy.ordereasyadmin.Adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oeasy.ordereasyadmin.R;
import com.oeasy.ordereasyadmin.Modal.WaiterFoodItems;

import java.util.List;

/**
 * Created by Dell on 06-04-2018.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder>{

    private  List<WaiterFoodItems> FoodList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView food_name,food_quantity;

        public MyViewHolder(View view) {
            super(view);
            food_name=(TextView)view.findViewById(R.id.foodname);
            food_quantity=(TextView)view.findViewById(R.id.foodquantity);
        }
    }


    public FoodAdapter(List<WaiterFoodItems> FoodList) {
        this.FoodList=FoodList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        WaiterFoodItems foodItems=FoodList.get(position);
        holder.food_name.setText(String.valueOf(foodItems.getMname()));
        holder.food_quantity.setText(""+foodItems.getMquantity());
    }

    @Override
    public int getItemCount() {
        return FoodList.size();
    }
}



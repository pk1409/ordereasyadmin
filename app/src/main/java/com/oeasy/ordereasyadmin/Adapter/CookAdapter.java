package com.oeasy.ordereasyadmin.Adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oeasy.ordereasyadmin.Modal.CookItems;
import com.oeasy.ordereasyadmin.R;

import java.util.List;

/**
 * Created by Dell on 06-04-2018.
 */

public class CookAdapter extends RecyclerView.Adapter<CookAdapter.MyViewHolder>{

    private  List<CookItems> CookList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView food_name,food_quantity,food_waitername,food_tablenum;

        public MyViewHolder(View view) {
            super(view);
            food_name=(TextView)view.findViewById(R.id.cook_foodname);
            food_quantity=(TextView)view.findViewById(R.id.cook_foodquantity);
            food_waitername=(TextView)view.findViewById(R.id.cook_waitername);
            food_tablenum=(TextView)view.findViewById(R.id.cook_tablenum);
        }
    }


    public CookAdapter(List<CookItems> CookList) {
        this.CookList=CookList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cook_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CookItems foodItems=CookList.get(position);
        holder.food_name.setText(String.valueOf(foodItems.getFoodname()));
        holder.food_quantity.setText(""+foodItems.getFoodquantity());
        holder.food_waitername.setText(foodItems.getWaiterName());
        holder.food_tablenum.setText(String.valueOf(foodItems.getTablenum()));
    }

    @Override
    public int getItemCount() {
        return CookList.size();
    }
}



package com.oeasy.ordereasyadmin;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.oeasy.ordereasyadmin.R;
import com.oeasy.ordereasyadmin.TableNum;

import java.util.List;

/**
 * Created by Dell on 06-04-2018.
 */

public class WaiterAdapter extends RecyclerView.Adapter<WaiterAdapter.MyViewHolder>{

    private List<TableNum> tableNumList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView table_number;
        private ConstraintLayout constraintLayout;
        private Button waiter_row_button;
        public MyViewHolder(View view) {
            super(view);
            table_number=(TextView)view.findViewById(R.id.waiter_tableno);
            constraintLayout=view.findViewById(R.id.constr_waiter_table);
            waiter_row_button=view.findViewById(R.id.waiter_table_button);
        }
    }


    public WaiterAdapter(Context context ,List<TableNum> FoodList)
    {
        this.tableNumList=FoodList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.waiter_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        TableNum TableItems=tableNumList.get(position);
        holder.table_number.setText(String.valueOf(TableItems.getTableno()));
        holder.waiter_row_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableNumList.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
            }
        });
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent( context,WaiterLayoutClicked.class);
                intent.putExtra("tablenumb",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableNumList.size();
    }
}


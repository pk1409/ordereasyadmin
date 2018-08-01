package com.oeasy.ordereasyadmin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.oeasy.ordereasyadmin.Modal.WaiterDetails;
import com.oeasy.ordereasyadmin.Others.Constants;
import com.oeasy.ordereasyadmin.Others.RequestHandler;
import com.oeasy.ordereasyadmin.R;
import com.oeasy.ordereasyadmin.Activities.Waiter.TableDetailsActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 06-04-2018.
 */

public class WaiterAdapter extends RecyclerView.Adapter<WaiterAdapter.MyViewHolder>{

    private List<WaiterDetails> wList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView table_number;
        private RelativeLayout rLayout;
        private TextView waiter_row_button;
        public MyViewHolder(View view) {
            super(view);
            table_number=view.findViewById(R.id.waiter_tableno);
            rLayout=view.findViewById(R.id.constr_waiter_table);
            waiter_row_button=view.findViewById(R.id.waiter_table_button);
        }
    }


    public WaiterAdapter(Context context ,List<WaiterDetails> wList)
    {
        this.wList=wList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.waiter_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        String TableItems=wList.get(position).getTableNo();
        holder.table_number.setText(TableItems);
        holder.waiter_row_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                informDatabase(wList.get(position).getId());
                wList.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
            }
        });
        holder.rLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent( context,TableDetailsActivity.class);
                intent.putExtra("tablenumb",position);
                context.startActivity(intent);
            }
        });
    }

    private void informDatabase(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL_PROCESS_REQUEST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOL",error.toString());
                Toast.makeText(context,"No Internet Connection",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                params.put("waiter_remove",String.valueOf(id));
                return params;
            }
        };
        RequestHandler.getInstance(context).addToRequestQueue(request);
    }

    @Override
    public int getItemCount() {
        return wList.size();
    }
}


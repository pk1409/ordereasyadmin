package com.oeasy.ordereasyadmin.Activities.Waiter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.oeasy.ordereasyadmin.Adapter.FoodAdapter;
import com.oeasy.ordereasyadmin.Modal.WaiterFoodItems;
import com.oeasy.ordereasyadmin.Others.Constants;
import com.oeasy.ordereasyadmin.Others.RequestHandler;
import com.oeasy.ordereasyadmin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.security.AccessController.getContext;

public class TableDetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<WaiterFoodItems> FoodList=new ArrayList<>();
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_details);
        recyclerView=findViewById(R.id.food_recycler_view);
        foodAdapter=new FoodAdapter(prepareFoodData());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(foodAdapter);
        getData();
    }
    private ArrayList<WaiterFoodItems> prepareFoodData(){
        return FoodList;

    }

    public void getData() {
        StringRequest request=new StringRequest(Request.Method.POST, Constants.URL_PROCESS_REQUEST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                params.put("home", "s");
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(request);
    }
}

package com.oeasy.ordereasyadmin.Activities.Waiter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.oeasy.ordereasyadmin.Adapter.WaiterAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaiterHomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<WaiterDetails> wList = new ArrayList<>();
    private WaiterAdapter waiterAdapter;
    SwipeRefreshLayout sLayout;

    private String uname;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter_home);
        initialize();
        getData();
        onSwipeRefresh();
    }

    private void onSwipeRefresh() {
        sLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }

    private void initialize() {
        recyclerView =  findViewById(R.id.waiter_recycler_view);
        wList.clear();
        waiterAdapter = new WaiterAdapter(this,wList);
        sLayout=findViewById(R.id.swipe_ref);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(waiterAdapter);
        uname=getIntent().getStringExtra("waiter_name");

    }



    public void getData() {
        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL_PROCESS_REQUEST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                JSONObject jOb=new JSONObject(response);


                    JSONArray jArr=jOb.getJSONArray("waiter");
                    for(int i=0;i<jArr.length();i++){
                        JSONObject jOb1=jArr.getJSONObject(i);
                        if(jOb1.get("table_no").toString().compareTo("0")!=0) {
                            WaiterDetails wD = new WaiterDetails();
                            wD.setId(String.valueOf(jOb1.get("id")));
                            wD.setTableNo((String) jOb1.get("table_no"));
                            wList.add(wD);
                            waiterAdapter.notifyDataSetChanged();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOL",error.toString());
                Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                params.put("get_table",uname);
                return params;
            }
        };
        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}
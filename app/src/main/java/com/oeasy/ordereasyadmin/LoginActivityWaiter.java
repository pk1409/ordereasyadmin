package com.oeasy.ordereasyadmin;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LoginActivityWaiter extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<TableNum> tableNumList = new ArrayList<>();
    private WaiterAdapter waiterAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_waiter);
        recyclerView = (RecyclerView) findViewById(R.id.waiter_recycler_view);
        waiterAdapter = new WaiterAdapter(this,tableNumList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(waiterAdapter);

        prepareTableData();
    }

    private void prepareTableData() {
        TableNum tabl = new TableNum("Table 1");
        tableNumList.add(tabl);

        tabl = new TableNum("Table 2");
        tableNumList.add(tabl);
        tabl = new TableNum("Table 3");
        tableNumList.add(tabl);
        tabl = new TableNum("Table 4");
        tableNumList.add(tabl);
        tabl = new TableNum("Table 5");
        tableNumList.add(tabl);
        tabl = new TableNum("Table 6");
        tableNumList.add(tabl);
        tabl = new TableNum("Table 7");

        tableNumList.add(tabl);
        tabl = new TableNum("Table 8");
        tableNumList.add(tabl);

        waiterAdapter.notifyDataSetChanged();


    }
}
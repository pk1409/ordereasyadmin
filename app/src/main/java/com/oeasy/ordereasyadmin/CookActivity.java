package com.oeasy.ordereasyadmin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

/**
 * Created by PRASHANT KRISHNA on 10-04-2018.
 */

public class CookActivity extends AppCompatActivity
{
RecyclerView cook_rec_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);
        cook_rec_view=findViewById(R.id.cook_recycler_view);

    }
}

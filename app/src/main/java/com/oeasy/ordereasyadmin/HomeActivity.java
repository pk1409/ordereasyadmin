package com.oeasy.ordereasyadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_mngr,bt_cook,bt_waiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialise();
        bt_mngr.setOnClickListener(this);
        bt_waiter.setOnClickListener(this);
        bt_cook.setOnClickListener(this);
    }

    private void initialise()
    {
        bt_mngr=findViewById(R.id.home_b1);
        bt_cook=findViewById(R.id.home_b2);
        bt_waiter=findViewById(R.id.home_b3);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.home_b1)
        {
            startActivity(new Intent(this,LoginActivity.class));
        }

        else if(view.getId()==R.id.home_b3)
        {
            startActivity(new Intent(this,LoginActivity.class));
        }
        else if(view.getId()==R.id.home_b2)
        {
            startActivity(new Intent(this,CookActivity.class));
        }

    }
}

package com.oeasy.ordereasyadmin.Activities.General;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.oeasy.ordereasyadmin.Activities.Cook.CookActivity;
import com.oeasy.ordereasyadmin.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_mngr,bt_cook,bt_waiter;
    String final_class,login_as;
    Intent intent;
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
            login_as="Manager";
            intent=new Intent(this,LoginActivity.class);
            intent.putExtra("key",login_as);
            startActivity(intent);
        }

        else if(view.getId()==R.id.home_b3)
        {

            login_as="Waiter";
            intent=new Intent(this,LoginActivity.class);
            intent.putExtra("key",login_as);
            startActivity(intent);
        }
        else if(view.getId()==R.id.home_b2)
        {
            intent=new Intent(this,CookActivity.class);
            startActivity(intent);
        }
    }
}

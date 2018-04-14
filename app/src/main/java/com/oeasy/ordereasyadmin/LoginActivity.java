package com.oeasy.ordereasyadmin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by PRASHANT KRISHNA on 10-04-2018.
 */

public  class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    Button bt_login,bt_cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt_login=findViewById(R.id.login_button);
        bt_cancel=findViewById(R.id.login_cancel);
        bt_login.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.login_button)
        {

        }
        else if(view.getId()==R.id.login_cancel)
        {

        }
    }
}

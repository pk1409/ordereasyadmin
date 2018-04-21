package com.oeasy.ordereasyadmin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivityManager extends AppCompatActivity{
    private Button Attendance_waiter;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_manager);
        Attendance_waiter=(Button) findViewById(R.id.button_attendance);
        Attendance_waiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),Attendance.class);
                startActivity(intent);
            }
        });
    }
}

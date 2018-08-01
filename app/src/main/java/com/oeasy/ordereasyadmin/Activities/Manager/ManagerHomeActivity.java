package com.oeasy.ordereasyadmin.Activities.Manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.oeasy.ordereasyadmin.Activities.Manager.AttendanceActivity;
import com.oeasy.ordereasyadmin.R;

public class ManagerHomeActivity extends AppCompatActivity{
    private Button Attendance_waiter;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);
        Attendance_waiter=(Button) findViewById(R.id.button_attendance);
        Attendance_waiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),AttendanceActivity.class);
                startActivity(intent);
            }
        });
    }
}

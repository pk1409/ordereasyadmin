package com.oeasy.ordereasyadmin.Activities.General;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.oeasy.ordereasyadmin.Activities.Manager.ManagerHomeActivity;
import com.oeasy.ordereasyadmin.Activities.Waiter.WaiterHomeActivity;

import com.oeasy.ordereasyadmin.Modal.WaiterDetails;
import com.oeasy.ordereasyadmin.Others.Constants;
import com.oeasy.ordereasyadmin.Others.RequestHandler;
import com.oeasy.ordereasyadmin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

/**
 * Created by PRASHANT KRISHNA on 10-04-2018.
 */

public  class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    Button bt_login,bt_cancel;
    String login_as;
    EditText uname,pword;
    WaiterDetails wDetails;
    int flag=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();

    }

    private void initialize() {
        login_as = getIntent().getStringExtra("key");
        bt_login=findViewById(R.id.login_button);
        bt_cancel=findViewById(R.id.login_cancel);
        uname=findViewById(R.id.login_username);
        pword=findViewById(R.id.login_password);
        wDetails=new WaiterDetails();

        bt_login.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.login_button)
        {
            if(login_as.equals("Manager")){
                Intent intent=new Intent(this,ManagerHomeActivity.class);
                startActivity(intent);

            }
            else if(login_as.equals("Waiter"))
            {
                int check=checkAuthenticity();
                if(check==-3){
                    Toast.makeText(this,"Both Username and Password field is Empty",Toast.LENGTH_SHORT).show();
                }
                else if (check==-1){
                    Toast.makeText(this,"Username not Entered",Toast.LENGTH_SHORT).show();
                }else if(check==-2){
                    Toast.makeText(this,"Password not Entered",Toast.LENGTH_SHORT).show();
                }
            }

        }
        else if(view.getId()==R.id.login_cancel)
        {
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
        }
    }

    private int checkAuthenticity() {

        if(uname.getText().toString().isEmpty()&&pword.getText().toString().isEmpty())return -3;
        if(uname.getText().toString().isEmpty())return -1;
        if(pword.getText().toString().isEmpty())return -2;
        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL_PROCESS_REQUEST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

               if(response.compareTo("1")==0){
                   Toast.makeText(getApplicationContext(),"Successfully Logged In",Toast.LENGTH_SHORT).show();
                   wDetails.setUsername(uname.getText().toString());
                   Intent intent = new Intent(getApplicationContext(), WaiterHomeActivity.class);
                   intent.putExtra("waiter_name",uname.getText().toString());
                   startActivity(intent);


               }else{
                   Toast.makeText(getApplicationContext(),"Username or Password is Incorrect",Toast.LENGTH_SHORT).show();
               }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOL",error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                JSONObject jObj=new JSONObject();
                try {
                    jObj.put("username",uname.getText().toString());
                    jObj.put("password",pword.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                params.put("waiter_login",jObj.toString());
                return params;
            }
        };
        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(request);
        if(flag==1)return 1;
        else return 0;
    }
}

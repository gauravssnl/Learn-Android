package com.gauravssnl.androtutor;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

public class InternetDemoActivity1 extends AppCompatActivity {
    
    public static final String TAG = "InternetDemoActivity1";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_demo1);
        
        Toolbar toolbar=findViewById(R.id.activity_internet_demo1Toolbar);
		setSupportActionBar(toolbar);
        
        textView = findViewById(R.id.activity_internet_demo1TextView);
        Button startBtn = findViewById(R.id.activity_internet_demo1Button);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findAndShowMyIP();
            }
        });
    }
    
    void findAndShowMyIP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
         String url = "http://checkip.amazonaws.com";
         StringRequest sreq =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
              public void onResponse(String response) {
                  textView.append("Your IP:" + response);
              }
         },
         new Response.ErrorListener() {
             public void onErrorResponse(VolleyError volleyError) {
                 textView.append("Error:" + volleyError.getMessage() + "\n");
             }
         });
         requestQueue.add(sreq);
    }
}

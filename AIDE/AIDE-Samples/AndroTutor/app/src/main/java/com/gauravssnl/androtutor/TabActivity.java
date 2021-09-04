package com.gauravssnl.androtutor;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TabActivity extends AppCompatActivity {
    
    public static final String TAG = "TabActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = findViewById(R.id.activity_tabToolbar);
        setSupportActionBar(toolbar);
        
    }
    
}

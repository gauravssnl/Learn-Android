package com.gauravssnl.androtutor;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ExpandableListView;
import android.widget.ExpandableListAdapter;

public class WidgetActivity extends AppCompatActivity {
    
    public static final String TAG = "WidgetActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        
        Toolbar toolBar = findViewById(R.id.activity_widgetToolbar);
        setSupportActionBar(toolBar); 
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
}

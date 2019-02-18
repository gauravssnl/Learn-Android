package com.gauravssnl.fragmentapp;

import android.app.*;
import android.os.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Intent intent = new Intent(this, SampleActivity.class);
		startActivity(intent);
		
    }
}

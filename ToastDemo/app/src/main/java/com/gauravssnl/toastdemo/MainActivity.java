package com.gauravssnl.toastdemo;

import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Toast.makeText(this, "Hello world", Toast.LENGTH_LONG).show();
    }
}

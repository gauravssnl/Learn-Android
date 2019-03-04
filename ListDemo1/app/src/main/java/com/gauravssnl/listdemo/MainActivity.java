package com.gauravssnl.listdemo;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	public void showList(View view) {
		Toast.makeText(this, "Showing List", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, TwoItemsActivity.class);
		startActivity(intent);
	}
}

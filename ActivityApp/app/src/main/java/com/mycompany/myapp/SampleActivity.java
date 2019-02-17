package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.graphics.*;

public class SampleActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		getWindow().getDecorView().setBackgroundColor(Color.RED);
	}
	
}

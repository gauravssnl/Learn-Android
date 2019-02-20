package com.gauravssnl.customview;
import android.app.*;
import android.os.*;

public class FirstActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(new CustomView(this));
	}
	
}

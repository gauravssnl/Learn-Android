package com.gauravssnl.customtextview;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;

public class FirstDemoActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		CustomTextView customTextView = new CustomTextView(this);
		customTextView.setText("Click here to generate random words");
		setContentView(customTextView);
		
	}
	
	
	
}

package com.gauravssnl.customtextview;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import android.view.View.*;
import android.view.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
		// startActivity(new Intent(this, FirstDemoActivity.class));
		LinearLayout parentLayout = new LinearLayout(this);
		parentLayout.setOrientation(LinearLayout.VERTICAL);
		parentLayout.setGravity(Gravity.CENTER);
		
		Button button1 = new Button(this);
		button1.setText("First Demo");
		// button1.setGravity(Gravity.CENTER);
		button1.setLayoutParams(new LinearLayout.LayoutParams(
		LinearLayout.LayoutParams.MATCH_PARENT,
		LinearLayout.LayoutParams.WRAP_CONTENT));
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View p1) {
				Intent intent = new Intent(MainActivity.this, FirstDemoActivity.class);
				startActivity(intent);
			}
		});
		parentLayout.addView(button1);
		
		Button button2 = new Button(this);
		button2.setText("Second Demo");
		// button2.setGravity(Gravity.CENTER);
		button2.setLayoutParams(new LinearLayout.LayoutParams(
									LinearLayout.LayoutParams.MATCH_PARENT,
									LinearLayout.LayoutParams.WRAP_CONTENT));
		button2.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1) {
					Intent intent = new Intent(MainActivity.this, SecondActivity.class);
					startActivity(intent);
				}
			});
		parentLayout.addView(button2);
		
		setContentView(parentLayout);
    }
}

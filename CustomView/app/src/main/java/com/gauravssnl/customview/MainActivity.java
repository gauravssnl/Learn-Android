package com.gauravssnl.customview;

import android.app.*;
import android.os.*;
import android.text.*;
import android.widget.*;
import android.view.*;
import android.view.View.*;
import android.content.*;
import android.graphics.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
		LinearLayout parentLayout = new LinearLayout(this);
		parentLayout.setOrientation(LinearLayout.VERTICAL);
		parentLayout.setGravity(Gravity.CENTER);
		Button firstBtn = new Button(this);
		firstBtn.setText("First Activity");
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT , LinearLayout.LayoutParams.WRAP_CONTENT);
		firstBtn.setLayoutParams(layoutParams);
		firstBtn.setTextColor(Color.RED);
		parentLayout.addView(firstBtn);
		
		Button secondBtn = new Button(this);
		secondBtn.setText("Second Activity");
		secondBtn.setLayoutParams(layoutParams);
		secondBtn.setTextColor(Color.BLUE);
		parentLayout.addView(secondBtn);
		
		setContentView(parentLayout);
		firstBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View p1) {
				// MainActivity.this has to be used
				Intent intent = new Intent(MainActivity.this, FirstActivity.class);
				startActivity(intent);
			}
		});
		
		secondBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1) {
					// MainActivity.this has to be used
					Intent intent = new Intent(MainActivity.this, SecondActivity.class);
					startActivity(intent);
				}
			});
		
    }
}

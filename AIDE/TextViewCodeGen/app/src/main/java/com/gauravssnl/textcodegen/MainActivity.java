package com.gauravssnl.textcodegen;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.lang.reflect.*;
import android.util.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
		LinearLayout parentLayout = new LinearLayout(this);
		parentLayout.setOrientation(LinearLayout.VERTICAL);
		
		TextView textView = new TextView(this);
		textView.setText("Hi world");
		textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
		textView.setGravity(Gravity.CENTER);
		
		LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		textView.setLayoutParams(layoutparams);
		
		parentLayout.addView(textView);
		setContentView(parentLayout);
    }
}

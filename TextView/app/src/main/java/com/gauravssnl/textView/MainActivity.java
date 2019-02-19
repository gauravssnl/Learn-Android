package com.gauravssnl.textView;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.util.*;
import android.view.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		TextView textView = findViewById(R.id.mainTextView1);
		textView.setText("Hello World");
		textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
		textView.setGravity(Gravity.CENTER);
    }
}

package com.gauravssnl.customtextview;
import android.content.*;
import android.util.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import java.util.*;

public class CustomTextView extends TextView
{
	private static final String[] WORDS = {
		"Hello", "World", "Android", "Fun", "Programming"
	};
	
	public CustomTextView(Context context) {
		super(context);
		setupLookAndFeel();
		setupClickListener();
	}
	
	public CustomTextView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		setupLookAndFeel();
		setupClickListener();
	}
	
	private void setupLookAndFeel(){
		setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);
		setGravity(Gravity.CENTER);
		setTextColor(Color.BLACK);
	}
	
	private String generateRandomWord() {
		// Grab the next random number
		int randomIndex = (int)(Math.random() * WORDS.length);
		return WORDS[randomIndex];
	}
	
	private void setupClickListener() {
		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View p1) {
				setText(generateRandomWord());
			}
		});
	}
}

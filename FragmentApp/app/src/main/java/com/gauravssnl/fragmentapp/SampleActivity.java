package com.gauravssnl.fragmentapp;
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
		if(savedInstanceState == null) {
			// use color Blue as background
			int color = Color.BLUE;
			// Create a new Instance of SampleFragment
			SampleFragment sampleFragment = SampleFragment.newInstance(color);
			
			// Get the FragmentManager
			getFragmentManager()
			.beginTransaction()
			.add(android.R.id.content, sampleFragment)
			.commit();
		}
	}
	
}

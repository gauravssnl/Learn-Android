package com.gauravssnl.multifragments;
import android.app.*;
import android.os.*;
import android.graphics.*;
import android.view.View.*;
import android.view.*;
import android.content.*;

public class SampleActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		
		// set the root view to the newly created activity_sample.xml
		setContentView(R.layout.activity_sample);
		findViewById(R.id.activity_sampleButton1).setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					Intent intent = new Intent(SampleActivity.this, SampleActivity.class);
					startActivity(intent);
				}

			
		});
		if(savedInstanceState == null) {
			SampleFragment sampleFragment1 = new SampleFragment().newInstance(Color.BLUE);
			SampleFragment sampleFragment2 = new SampleFragment().newInstance(Color.RED);
			getFragmentManager()
			.beginTransaction()
			.add(R.id.activity_sampleFrameLayout1, sampleFragment1)
			.add(R.id.activity_sampleFrameLayout2, sampleFragment2)
			.commit();
		}
	}
	
}

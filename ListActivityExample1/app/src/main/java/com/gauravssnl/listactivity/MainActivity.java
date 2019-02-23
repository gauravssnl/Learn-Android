package com.gauravssnl.listactivity;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.view.View.*;
import android.content.*;
import android.support.v7.app.*;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button listButton =(Button) findViewById(R.id.mainButton1);
		listButton.setText("Show List");
		listButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, ListActivityExample.class);
				startActivity(intent);
			}
		});
		Button twoItemslistButton = (Button)findViewById(R.id.mainButton2);
		twoItemslistButton.setText("Show Two Items List");
		twoItemslistButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent intent = new Intent(MainActivity.this, TwoItemsActivity.class);
					startActivity(intent);
				}
			});
    }
}

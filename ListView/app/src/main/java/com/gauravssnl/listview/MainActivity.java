package com.gauravssnl.listview;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.view.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final String[] items = {"Python", "JavaScript", "TypeScript", "Java"};
		ArrayAdapter<String> stringList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		// stringList.addAll(items);
		ListView listView =  findViewById(R.id.mainListView);
		listView.setAdapter(stringList);
		listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
				{
					// TODO: Implement this method
					Toast.makeText(MainActivity.this, items[pos], Toast.LENGTH_SHORT).show();
				}
		});
		
    }
}

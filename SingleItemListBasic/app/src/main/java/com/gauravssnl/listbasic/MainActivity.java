package com.gauravssnl.listbasic;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.view.*;

public class MainActivity extends AppCompatActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
		setContentView(R.layout.activity_main_list);
		final String[] fruits = new String[] {"Orange", "Banana", "Pear", "Pineapple", "Mango", "Strawberry",
			"Apple", "Peach", "Watermelon", "Kiwi", "Cherry", "Grape", "Fig", "Plum", "Quince",
			"Avocado", "Pomegranate", "Lime", "Mandarin", "Grapefruit", "Raspberry", "Melon", "Pomelo"};
		ArrayAdapter<String> stringList = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1 , fruits);
		ListView listView = (ListView) findViewById(R.id.activity_main_listListView);
		listView.setAdapter(stringList);
		listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
				Toast.makeText(MainActivity.this, fruits[position], Toast.LENGTH_SHORT).show();
			}
		});
    }
}

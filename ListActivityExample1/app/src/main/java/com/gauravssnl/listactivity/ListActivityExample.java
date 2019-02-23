package com.gauravssnl.listactivity;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class ListActivityExample extends ListActivity
{
	private final String[] items = {"Python", "JavaScript", "TypeScript", "Java"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.itemTextView, items);
		setListAdapter(stringAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		// TODO: Implement this method
		super.onListItemClick(l, v, position, id);
		Toast.makeText(this, items[position],Toast.LENGTH_SHORT).show();
	}
	
	
}

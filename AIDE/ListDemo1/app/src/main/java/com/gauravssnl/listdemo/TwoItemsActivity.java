package com.gauravssnl.listdemo;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;

public class TwoItemsActivity extends Activity
{
	final String[] fruits = {"Orange", "Apple", "Grapes", "Melon"};
	final String[] colors = {"Orange", "Red", "Green", "Green"};
	private static final int INVALID_LAYOUT = -1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_items_activity);
		ArrayAdapter<String> stringList = new ArrayAdapter<String>(this, INVALID_LAYOUT, fruits){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				LayoutInflater inflater = (LayoutInflater) TwoItemsActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View inflatedView = inflater.inflate(R.layout.two_lines_item, null);
				((TextView)inflatedView.findViewById(R.id.two_lines_itemTextView1)).setText(fruits[position]);
				((TextView)inflatedView.findViewById(R.id.two_lines_itemTextView2)).setText(colors[position]);
				return inflatedView;
			}
		};
		
		ListView  listview = findViewById(R.id.two_items_activityListView);
		listview.setAdapter(stringList);
	}
	
	
}

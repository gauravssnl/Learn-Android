package com.gauravssnl.listactivity;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.support.v7.app.AppCompatActivity;

public class TwoItemsActivity extends AppCompatActivity
{
	final String[] fruits = {"Orange", "Banana","Melon", "Grape", "Pomegranate"};
	final String[] colors = {"Orange", "Yellow", "Green", "Green", "Red"};
	private static int INVALID_LAYOUT = -1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_items_activity);
		ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(this, INVALID_LAYOUT) {
			@Override
			public View getView(int position, View convertViw, ViewGroup parent) {
				LayoutInflater inflater = (LayoutInflater) TwoItemsActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View inflatedView = inflater.inflate(R.layout.two_lines_items, null);
				((TextView)inflatedView.findViewById(R.id.two_lines_itemsTextView1)).setText(fruits[position]);
				((TextView)inflatedView.findViewById(R.id.two_lines_itemsTextView2)).setText(colors[position]);
				return inflatedView;
			}
		};
		
		ListView listview = (ListView) findViewById(R.id.two_items_activityListView);
		listview.setAdapter(stringAdapter);
	}
	
}

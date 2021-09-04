package com.gauravssnl.twoitems;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.view.*;
import android.content.*;

public class MainActivity extends AppCompatActivity 
{
	final String[] fruits = new String[] {"Orange", "Banana", "Pear", "Pineapple", "Mango",
		"Strawberry",  "Apple", "Peach", "Watermelon", "Kiwi", "Cherry", "Grape", "Fig",
		"Plum", "Quince", "Avocado", "Pomegranate", "Lime", "Mandarin", "Grapefruit",
		"Raspberry", "Melon", "Pomelo"};

    final String[] colors = new String[] {"orange", "yellow", "green", "brown", "orangeish",
		"red", "red", "orange", "green", "brown", "red", "green", "burgundy", "burgundy",
		"yellow", "green", "red", "green", "orange", "orange", "red", "green", "green"};

    private static final int INVALID_LAYOUT = -1;

    /**
     * Not optimized implementation. Just shown as reference, optimized version using ViewHolder
     * pattern and reusing views can be found in the<code>OptimizedTwoItemsActivity</code> class
     */
	 
	 // optimized list example
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
		setContentView(R.layout.activity_main_list);
		
		ArrayAdapter<String> stringList = new ArrayAdapter<String>(this, INVALID_LAYOUT, fruits) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder holder;
				if(convertView == null ) {
					LayoutInflater infalter = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = infalter.inflate(R.layout.two_lines_item, null);
					holder = new ViewHolder();
					holder.text1 = ((TextView)convertView.findViewById(R.id.itemTextView1));
					holder.text2 = ((TextView)convertView.findViewById(R.id.itemTextView2));
					convertView.setTag(holder);
				} else {
					holder = (ViewHolder) convertView.getTag();
				}
				holder.text1.setText(fruits[position]);
				holder.text2.setText(colors[position]);
				return convertView;
				
			}
		} ;
		ListView listView = (ListView) findViewById(R.id.activity_main_listListView);
		listView.setAdapter(stringList);
		listView.setOnItemClickListener(new OnItemClickListener(){
				@Override
				public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
					Toast.makeText(MainActivity.this, fruits[position], Toast.LENGTH_SHORT).show();
				}
			});
    }
	
	private static class ViewHolder {
		TextView text1;
		TextView text2;
	}
}


package com.gauravssnl.twoitems;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.view.*;
import android.content.*;
import android.graphics.*;

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
					holder.image = ((ImageView)convertView.findViewById(R.id.two_lines_itemImageView));
					convertView.setTag(holder);
				} else {
					holder = (ViewHolder) convertView.getTag();
				}
				holder.text1.setText(fruits[position]);
				holder.text2.setText(colors[position]);
				holder.position = position;
				new ImageLoader(position, holder).execute();
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
	
	private static class ImageLoader extends AsyncTask<ViewHolder, Void, Bitmap> {
		private ViewHolder holder;
		private int position;
		
		public ImageLoader(int position, ViewHolder holder) {
			this.position = position;
			this.holder = holder;
		}

		@Override
		protected Bitmap doInBackground(MainActivity.ViewHolder[] p1)
		{
			// TODO: Implement this method
			return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
		}

		@Override
		protected void onPostExecute(Bitmap result)
		{
			// TODO: Implement this method
			// super.onPostExecute(result);
			if(position == holder.position) {
				holder.image.setImageBitmap(result);
			}
		}
		
		
	}
	
	private static class ViewHolder {
		TextView text1;
		TextView text2;
		int position;
		ImageView image;
	}
}


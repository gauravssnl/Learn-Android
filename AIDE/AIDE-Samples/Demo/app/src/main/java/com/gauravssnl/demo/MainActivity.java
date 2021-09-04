package com.gauravssnl.demo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import androidx.appcompat.view.menu.MenuBuilder;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import android.content.res.ColorStateList;
import android.graphics.Color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.graphics.drawable.Icon;
import android.widget.Button;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import androidx.core.app.NotificationManagerCompat;
import android.content.Intent;
import android.app.PendingIntent;
import androidx.core.app.RemoteInput;
import android.util.Log;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.Gravity;
import androidx.core.view.GravityCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnDoubleTapListener;
import android.widget.EditText;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
	
	public static final String TAG = "MainActivity";
    Toolbar toolbar;
	DrawerLayout drawerLayout;
	ActionBarDrawerToggle actionBarDrawerToggle;
	FloatingActionButton faBtn;
	final static String CHANNEL_ID = "1";
	final static String KEY_TEXT_REPLY = "key_text_reply";
	EditText editText;
	GestureDetectorCompat gestureDetectorCompat;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		this.gestureDetectorCompat = new GestureDetectorCompat(this, this);
		gestureDetectorCompat.setOnDoubleTapListener(this);
		
		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		//drawer layout instance to toggle the menu icon to open 
		// drawer and back button to close drawer
//		drawerLayout = findViewById(R.id.activity_main_drawer_layout);
//		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
//
		// pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
//		drawerLayout.addDrawerListener(actionBarDrawerToggle);
//		actionBarDrawerToggle.syncState();
		
		//Show home side drawer icon
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);// set drawable icon
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
//		if (drawerLayout.isDrawerOpen(GravityCompat.END))
//			drawerLayout.closeDrawer(GravityCompat.END);
//		if (drawerLayout.isDrawerOpen(GravityCompat.START))
//			drawerLayout.closeDrawer(GravityCompat.START);
		
		editText = findViewById(R.id.activity_mainEditText1);
		
		setFabBtn1Proprties();
		
		setBtn1Proprties();
		
		setBtn2Properties();
		
		
		
	}
	
	// we need to override this to detect gestures
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Toast.makeText(this, "set up onTouchEvent", Toast.LENGTH_SHORT)
			.show();
		this.gestureDetectorCompat.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

//	@Override
//	public void onBackPressed() {
//		if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
//			drawerLayout.closeDrawer(GravityCompat.END);
//		} else if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//			drawerLayout.closeDrawer(GravityCompat.START);
//		} else
//			super.onBackPressed();
//	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		toolbar.inflateMenu(R.menu.main_activity_menu);
		MenuBuilder mb = (MenuBuilder) menu; 
		mb.setOptionalIconsVisible(true);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
//		if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//			if (drawerLayout.isDrawerOpen(GravityCompat.END))
//				drawerLayout.closeDrawer(GravityCompat.END);
//			if (drawerLayout.isDrawerOpen(GravityCompat.START))
//				drawerLayout.closeDrawer(GravityCompat.START);
//            return true;
//
//        }
		switch(item.getItemId()) {
			case android.R.id.home:
				Toast.makeText(getApplicationContext(), R.string.toolbar_home_click,Toast.LENGTH_SHORT)
					.show();
				//actionBarDrawerToggle.syncState();

				//drawerLayout.closeDrawer(GravityCompat.START);

				break;
			case  R.id.main_about:
				new AboutDialogFragment()
					.show(getFragmentManager(),AboutDialogFragment.TAG);
				break;
			case R.id.main_settings:
				View contextView  = findViewById(R.id.activity_mainLinearLayout1);
				Snackbar sb = Snackbar.make(contextView, R.string.launching_settings, Snackbar.LENGTH_SHORT);
				sb.setActionTextColor(ColorStateList.valueOf(Color.RED));             
				sb.setAction(R.string.ok, new OnClickListener(){
					public void onClick(View v1) {
						//v1.setVisibility(0);
					}
				}).show();
				Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
				startActivity(intent);
				// Log.i(TAG, "Starting intent");
				break;
			default:
				return super.onOptionsItemSelected(item);
		}
		return true;
	}

	public void setFabBtn1Proprties() {
		faBtn = findViewById(R.id.activity_mainFloatingActionButton1);
		faBtn.setRippleColor(Color.YELLOW);
		faBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final Snackbar sb = Snackbar.make(view, R.string.fab_btn1_click_msg, Snackbar.LENGTH_INDEFINITE);
				sb.setAction(R.string.ok,new View.OnClickListener() {
					@Override          
					public void onClick(View v1) {
						sb.dismiss();
					}
				});
				sb.show();
				
			}
		});
	}
	
	public void setBtn1Proprties() {
		Button b1 = findViewById(R.id.activity_mainButton1);
		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View p1) {
				
				CharSequence name = getString(R.string.channel_name);
				String description = getString(R.string.channel_description);
				int importance = NotificationManager.IMPORTANCE_DEFAULT;
				NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
				channel.setDescription(description);
				//NotificationManager notificationManager = getSystemService(NotificationManager.class);
				//notificationManager.createNotificationChannel(channel);
				String contenttTitle = getString(R.string.notification_title);
				String contentText = getString(R.string.notification_message);;

				// Set the notification's Tap Action
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

				// Add reply button in the notification
				String replyLabel = getResources().getString(R.string.reply_label);
				RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
					.setLabel(replyLabel).build();
				// Build a PendingIntent for the reply action
				int CONVERSATION_ID = 1;
				PendingIntent replyPendingIntent = PendingIntent.getBroadcast(
					getApplicationContext(), CONVERSATION_ID, intent,  PendingIntent.FLAG_UPDATE_CURRENT);

				// Create the reply action and add the remote input.
				NotificationCompat.Action action =  new NotificationCompat.Action.Builder(
					R.drawable.ic_message,
					getString(R.string.type_answer), replyPendingIntent)
					.addRemoteInput(remoteInput)
					.build();
					
				NotificationCompat.Builder builder = new  NotificationCompat.Builder(MainActivity.this, CHANNEL_ID) 
					.setSmallIcon(R.drawable.ic_android_debug_bridge)
					.setContentTitle(contenttTitle)
					.setContentText(contentText)
					.addAction(action)
					.setStyle(new NotificationCompat.BigTextStyle().bigText(contentText))
					.setPriority(NotificationCompat.PRIORITY_DEFAULT)
					.setContentIntent(pendingIntent)
					.setAutoCancel(true);
				NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());

				int NOTIFICATION_ID =1;
				notificationManager.notify(NOTIFICATION_ID, builder.build());
			} 
		});
	}
	
	public void setBtn2Properties() {
		Button b2 = findViewById(R.id.activity_mainButton2);
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Toast.makeText(getApplicationContext(),R.string.cool_app, Toast.LENGTH_LONG)
					.show();
			}
		});
	}

	@Override
	public boolean onDown(MotionEvent p1) {
		editText.append("onDown" + "\n");
		return true;
	}

	@Override
	public boolean onFling(MotionEvent p1, MotionEvent p2, float p3, float p4) {
		editText.append("onFling" + "\n");
		return true;
	}

	@Override
	public void onLongPress(MotionEvent p1) {
		editText.append("onLongPress" + "\n");
	}

	@Override
	public boolean onScroll(MotionEvent p1, MotionEvent p2, float p3, float p4) {
		editText.append("onScroll" + "\n");
		return true;
	}

	@Override
	public void onShowPress(MotionEvent p1) {
		editText.append("onShowPress" + "\n");
	}

	@Override
	public boolean onSingleTapUp(MotionEvent p1) {
		editText.append("onSingleTapUp" + "\n");
		return true;
	}

	@Override
	public boolean onDoubleTap(MotionEvent p1) {
		editText.append("onDoubleTap" + "\n");
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent p1) {
		Toast.makeText(this, "onDoubleTapEvent", Toast.LENGTH_SHORT)
			.show();
		editText.append("onDoubleTapEvent" + "\n");
		return true;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent p1) {
		editText.append("onSingleTapConfirmed" + "\n");
		return true;
	}
}

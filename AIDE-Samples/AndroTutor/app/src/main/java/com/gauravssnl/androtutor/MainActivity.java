package com.gauravssnl.androtutor;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Adapter;
import com.google.android.material.snackbar.Snackbar;
import android.text.Layout;
import android.view.MenuItem;
import android.view.Menu;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.core.content.IntentCompat;
import android.widget.Toast;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public final  String[] itemNames  = {
        "Widget",
        "View",
        "Layout",
        "Advanced Widget",
        "Adapter View",
        "Layout",
        "Scroll View",
        "Advanced Layout",
        "App Layout",
        "Tab",
        "Toast",
        "Snackbar",
        "Notification",
        "Intent",
        "Services",
        "Broadcast",
        "Internet",
    };
    
    ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar=findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
        
        setupListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu,menu);
        ((MenuBuilder) menu).setOptionalIconsVisible(true);
        return true;
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.activity_mainAboutMenu:
                showAboutDialog();
                break;
            case R.id.activity_mainBatteryMenu:
                Intent intent = new Intent(getApplicationContext(), BatteryActivity.class);
                startActivity(intent);
                break;
            default:
                return false;
        }
        return true;
    }
    
    
    protected void setupListView() {
        listView = findViewById(R.id.activity_mainListView);
        List<String> itemNamesList = Arrays.asList(itemNames);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(itemNamesList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos,  long id) {
                String item = itemNames[pos];
//                Snackbar.make(view, "You clicked on : " + item, Snackbar.LENGTH_SHORT)
//                    .show();
                Toast.makeText(getApplicationContext(), "You clicked on : " + item, Toast.LENGTH_SHORT).show();
                Intent intent;
                switch (item) {
                    case "Widget":
                        intent = new Intent(getApplicationContext(), WidgetActivity.class);
                        startActivity(intent);
                        break;
                    case "Tab":
                        intent = new Intent(getApplicationContext(), TabActivity.class);
                        startActivity(intent);
                        break;
                    case "Internet":
                        intent = new Intent(getApplicationContext(), InternetDemoActivity1.class);
                        startActivity(intent);
                        break;
                    default:
                        return;
                }
                
                
               }
        });
    }
    
    protected void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(R.string.about_dialog_message);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}


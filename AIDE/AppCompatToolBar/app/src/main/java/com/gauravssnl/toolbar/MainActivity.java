package com.gauravssnl.toolbar;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;

import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        //toolbar.setSubtitle("Subtitle");

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.R.drawable.ic_dialog_alert);
        toolbar.setNavigationOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Toolbar", Toast.LENGTH_SHORT).show();
                }
            }
        );
    }
}

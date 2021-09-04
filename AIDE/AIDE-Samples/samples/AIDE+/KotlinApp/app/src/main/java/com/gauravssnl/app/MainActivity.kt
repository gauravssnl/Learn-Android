package com.gauravssnl.app;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import adrt.ADRTLogCatReader
import android.view.Menu 

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ADRTLogCatReader.onContext(this@MainActivity, "com.aide.lts")
        setContentView(R.layout.activity_main)
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
    	getMenuInflater().inflate(R.menu.activity_main_menu, menu);
    	return true;
    }
}

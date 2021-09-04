package com.gauravssnl.demo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import java.util.Locale;
import android.os.LocaleList;
import android.content.res.Configuration;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		LocaleList localeList  = getApplicationContext().getResources()
			.getConfiguration().getLocales();
		Locale locale = new Locale("hi");
		//if (localeList.size() > 1)
		Locale.setDefault(locale);
		Configuration configuration = getApplicationContext().getResources().getConfiguration(); 

		configuration.setLocale(locale); 

		configuration.setLayoutDirection(locale); 



		getApplicationContext().createConfigurationContext(configuration); 
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar); 
    }
    
}

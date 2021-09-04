package com.gauravssnl.androtutor;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.BatteryManager;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;

public class BatteryActivity extends AppCompatActivity {
    
    public static final String TAG = "BatteryActivity";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        
        Toolbar toolbar = findViewById(R.id.activity_batteryToolbar);
        setSupportActionBar(toolbar);
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_battery_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
                case R.id.about_feku:
                    showAboutDialog();
                    return true;
                default:
                return super.onOptionsItemSelected(item);
        }
        
    }
    
    void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(BatteryActivity.this);
        builder.setMessage("इस एप्लिकेशन को मोदी द्वारा विकसित किया गया है।\nमोदी एक महान वैज्ञानिक और प्रोग्रामर हैं।\nमोदी लीजेंड हैं (नंबर 1 फेकू)।\nआप मुझे गूगल पर सर्च कर सकते हैं: फेकू लिख कर सर्च बटन दबायें|" );
        builder.setPositiveButton("ठीक है",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface p1, int p2) {
                p1.dismiss();
            }
        });
        builder.create().show();
    }
    
}

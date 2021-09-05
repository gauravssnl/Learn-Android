package com.gauravssnl.tipster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gauravssnl.tipster.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RadioGroup rdoGroupTips;

    // For the ID of the radio button selected
    private int radioCheckedId = -1;

    private EditText txtAmount;
    private EditText txtPeople;
    private EditText txtTipOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setSupportActionBar(binding.toolBar);

        txtAmount = binding.txtAmount;
        txtAmount.requestFocus();

        txtAmount = binding.txtAmount;
        txtPeople = binding.txtPeople;
        txtTipOther = binding.txtTipOther;

        rdoGroupTips = binding.RadioGroupTips;
        rdoGroupTips.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioFifteen:
                        Toast.makeText(getApplicationContext(), "You clicked on 15", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioTwenty:
                            Toast.makeText(getApplicationContext(), "You clicked on 20", Toast.LENGTH_SHORT).show();
                            break;
                    case R.id.radioOther:
                        Toast.makeText(getApplicationContext(), "You clicked on Other", Toast.LENGTH_SHORT).show();
                        txtTipOther.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        });
        txtAmount.setOnKeyListener(mKeyListener);
        txtPeople.setOnKeyListener(mKeyListener);
        txtTipOther.setOnKeyListener(mKeyListener);

        txtTipOther.setEnabled(false);

    }

    private View.OnKeyListener mKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
            switch (view.getId()) {
                case R.id.txtAmount:
                    Toast.makeText(getApplicationContext(), "txtAmount - Key Pressed: " + keyCode + "Key Event: " + keyEvent, Toast.LENGTH_SHORT).show();
                    if (txtAmount.getEditableText().toString().contains("2000")) {
                        showErrorAlert("Limit exceeded", R.id.txtPeople); // only for demo; not real world logic
                    }
                    break;
                case R.id.txtPeople:
                    Toast.makeText(getApplicationContext(), "txtPeople - Key Pressed: " + keyCode, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.txtTipOther:
                    Toast.makeText(getApplicationContext(), "txtTipOther - Key Pressed: " + keyCode, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return false;
        }
    };

    private void showErrorAlert(String errorMessage, final int fieldId) {
        new AlertDialog.Builder(this).setTitle("Error")
                .setMessage(errorMessage).setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                // Make error field focusable
                binding.getRoot().findViewById(fieldId).requestFocus();
            }
        }).show();
    }
}
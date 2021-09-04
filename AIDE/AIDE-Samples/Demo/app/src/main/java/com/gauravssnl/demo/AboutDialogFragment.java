package com.gauravssnl.demo;
import android.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

public class AboutDialogFragment extends DialogFragment {
	
	public static final String TAG = "AboutDialogFragment";
	//private Dialog myDialog;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
		.setPositiveButton("OK", new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int id) {
				EditText editText = getActivity().findViewById(R.id.activity_mainEditText1);
				editText.append("Clicked on AboutDialogFragment OK button\n");
				//if (myDialog != null)
				//	myDialog.hide();
				dialog.dismiss();
			}
		});
		builder.setMessage(R.string.about_menu);
		builder.setCancelable(true);
		//myDialog = builder.create();
		//return myDialog;
		return builder.create();
	}
	
}

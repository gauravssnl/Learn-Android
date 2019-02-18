package com.gauravssnl.fragmentapp;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

public class SampleFragment extends Fragment
{
	public static final String COLOR = "color";
	
	public static SampleFragment newInstance(int color) {
		SampleFragment sampleFragment = new SampleFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(COLOR, color);
		sampleFragment.setArguments(bundle);
		return sampleFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		// return super.onCreateView(inflater, container, savedInstanceState);
		// Grab color from Bundle
		int color = getArguments().getInt(COLOR, Color.BLUE);
		// Create the Root View
		FrameLayout frameLayout = new FrameLayout(getActivity());
		// set background color
		frameLayout.setBackgroundColor(color);
		return frameLayout;
	}
	
}

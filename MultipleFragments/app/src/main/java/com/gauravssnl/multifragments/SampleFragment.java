package com.gauravssnl.multifragments;
import android.app.*;
import android.os.*;
import android.view.*;
import android.graphics.*;
import android.widget.*;

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
		int color = getArguments().getInt(COLOR, Color.RED);
		FrameLayout frameLayout = new FrameLayout(getActivity());
		frameLayout.setBackgroundColor(color);
		return frameLayout;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	
}

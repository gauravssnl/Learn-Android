package com.gauravssnl.customview;
import android.view.View;
import android.content.*;
import android.util.*;
import android.graphics.*;

public class CustomView extends View
{
	private Paint mPaint;
	
	public CustomView(Context context) {
		super(context);
		init();
	}
	
	public CustomView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		init();
	}
	
	private void init() {
		mPaint = new Paint();
		mPaint.setColor(Color.BLACK);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO: Implement this method
		super.onDraw(canvas);
		canvas.drawRect(0, 0, getWidth() / 2, getHeight(), mPaint);
	}
	
	
	
	
}

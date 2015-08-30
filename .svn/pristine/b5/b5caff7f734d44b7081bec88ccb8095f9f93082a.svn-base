package com.hzf.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

/**
 * 回弹listview BounceListView.java
 * 
 * @author zongfa_he
 * @version
 * @since 2014-9-30 下午1:40:18
 * @description
 * 
 */
public class BounceListView extends ListView {
	private boolean outBound = false;
	private int distance;
	private int firstOut;
	private Context mContext;
	private BounceCallBack mBounceCallback;
	public static final String TAG = "BounceListView";
	private boolean isCalled = false;

	public BounceListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
	}

	public BounceListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
	}

	public BounceListView(Context context) {
		super(context);
		mContext = context;
	}

	GestureDetector gestureDetector = new GestureDetector(mContext,
			new OnGestureListener() {
				@Override
				public boolean onSingleTapUp(MotionEvent e) {
					// TODO Auto-generated method stub
					Log.d(TAG, "I'am onSingleTapUp().");
					return false;
				}

				@Override
				public void onShowPress(MotionEvent e) {
					// TODO Auto-generated method stub
					Log.d(TAG, "I'am onShowPress().");
				}

				@Override
				public boolean onScroll(MotionEvent e1, MotionEvent e2,
						float distanceX, float distanceY) {
					Log.e(TAG, "Entry onscroll distanceX = " + distanceX
							+ ", distanceY = " + distanceX);
					int firstPos = getFirstVisiblePosition();

					// outbound Top
					if (outBound && firstPos != 0) {
						scrollTo(0, 0);
						return false;
					}
					View firstView = getChildAt(firstPos);
					// View lastView = getChildAt(lastPos - 1);
					if (!outBound) {
						firstOut = (int) e2.getRawY();
					}

					if (firstView != null
							&& (outBound || (firstPos == 0
									&& firstView.getTop() == 0 && distanceY < 0))) {
						// Record the length of each slide
						distance = firstOut - (int) e2.getRawY();
						Log.e(TAG, "Lee--------distance = " + distance);
						Log.e(TAG, "firstOut = " + firstOut + ", firstPos = "
								+ firstPos + ", firstView.getTop() = "
								+ firstView.getTop());
						int tempdistance = 60 * (-distance) / 100; // 为了增加下拉的难�?
						if (tempdistance > getHeight() / 2)
							scrollTo(0, -getHeight() / 2);
						else
							scrollTo(0, -tempdistance);
						if (mBounceCallback != null
								&& shouldCallBack(tempdistance)) {
							isCalled = true;
							mBounceCallback.onBounceCallBack();
						}
						return true;
					}

					return false;
				}

				@Override
				public void onLongPress(MotionEvent e) {
					// TODO Auto-generated method stub
					Log.d(TAG, "I'am onLongPress().");
				}

				@Override
				public boolean onFling(MotionEvent e1, MotionEvent e2,
						float velocityX, float velocityY) {
					// TODO Auto-generated method stub
					Log.d(TAG, "I'am onFling().");
					return false;
				}

				@Override
				public boolean onDown(MotionEvent e) {
					// TODO Auto-generated method stub
					Log.d(TAG, "I'am onDown().");
					return false;
				}
			});

	private boolean shouldCallBack(int tempdistance) {

		if ((tempdistance > getHeight() / 2) && !isCalled) { // 下拉到ListView高度的一半就会触发事�?
			Log.e(TAG, "shouldCallBack()");
			return true;
		}
		return false;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		int act = event.getAction();
		if ((act == MotionEvent.ACTION_UP || act == MotionEvent.ACTION_CANCEL)
				&& outBound) {
			outBound = false;
			isCalled = false;
			// scroll back
		}
		if (!gestureDetector.onTouchEvent(event)) {
			outBound = false;
		} else {
			outBound = true;
		}
		Rect rect = new Rect();
		getLocalVisibleRect(rect);
		Log.i(TAG, "rect.top = " + rect.top);
		TranslateAnimation am = new TranslateAnimation(0, 0, -rect.top, 0);
		am.setDuration(300);
		startAnimation(am);
		scrollTo(0, 0);

		return super.dispatchTouchEvent(event);
	}

	public void setOnBounceCallBack(BounceCallBack callback) {
		mBounceCallback = callback;
	}

	// 回调触发接口
	public interface BounceCallBack {
		public void onBounceCallBack();
	}
}
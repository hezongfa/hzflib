package com.hzf.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class CountBackwardsButton extends Button {
	Context context;
	CountDownTimer timer;
	private long countDownInterval = 1000;// 心跳间隔时间 毫秒
	private long timescount = 60;// 心跳次数
	private String tipStr = "%d秒后再次获取";
	private String defTextStr = "获取验证码";
	private int defDrawableRes = 0;
	private int pressDrawableRes = 0;
	private OnClick onClick;

	public void setOnClick(OnClick onClick) {
		this.onClick = onClick;
	}

	public void setDefDrawableRes(int defDrawableRes) {
		this.defDrawableRes = defDrawableRes;
		setBackgroundResource(defDrawableRes);
	}

	public void setPressDrawableRes(int pressDrawableRes) {
		this.pressDrawableRes = pressDrawableRes;
	}

	public CountBackwardsButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public CountBackwardsButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		this.context = context;
		if (!TextUtils.isEmpty(getText())) {
			defTextStr = getText().toString();
		}
		initTimer();
		setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (onClick != null) {
					if (onClick.onClick(CountBackwardsButton.this)) {
						if (timer == null) {
							initTimer();
						}
						timer.start();
						setEnabled(false);
						if (pressDrawableRes != 0) {
							setBackgroundResource(pressDrawableRes);
						}
					}
				}
			}
		});
	}

	public void setCountDownInterval(long countDownInterval) {
		this.countDownInterval = countDownInterval;
		initTimer();
	}

	public void setTimescount(long timescount) {
		this.timescount = timescount;
		initTimer();
	}

	private void initTimer() {
		if (timer != null) {
			timer.cancel();
			timer = null;
			setEnabled(true);
			if (defDrawableRes != 0) {
				setBackgroundResource(defDrawableRes);
			}
		}
		timer = new CountDownTimer(timescount * countDownInterval,
				countDownInterval) {

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				String str = String.format(tipStr, millisUntilFinished
						/ countDownInterval);
				setText(str);
			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				setText(defTextStr);
				setEnabled(true);
				if (defDrawableRes != 0) {
					setBackgroundResource(defDrawableRes);
				}
			}
		};
	}

	public void cancle() {
		if (timer != null) {
			timer.cancel();
		}
	}

	public interface OnClick {
		public boolean onClick(View v);
	}
}

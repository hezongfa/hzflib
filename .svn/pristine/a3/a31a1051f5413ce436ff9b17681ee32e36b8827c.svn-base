package com.hzf.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzf.R;

public class TopBarView extends RelativeLayout {
	Context context;
	public RelativeLayout hzf_topbarLay;
	public TextView hzf_tvTitle;
	public Button hzf_leftBtn, hzf_rightBtn;
	public LinearLayout hzf_centerCusLay;

	public TopBarView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public TopBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
	}

	private void init(Context context) {
		this.context = context;
		LayoutInflater.from(context).inflate(R.layout.hzf_topbar, this);
		hzf_topbarLay = (RelativeLayout) findViewById(R.id.hzf_topbarlay);
		hzf_tvTitle = (TextView) findViewById(R.id.hzf_top_tvTitle);
		hzf_leftBtn = (Button) findViewById(R.id.hzf_top_btnLeft);
		hzf_rightBtn = (Button) findViewById(R.id.hzf_top_btnRight);
		hzf_centerCusLay = (LinearLayout) findViewById(R.id.hzf_centerCusLay);

	}
}

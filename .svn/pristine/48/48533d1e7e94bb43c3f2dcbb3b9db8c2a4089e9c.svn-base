package com.hzf.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hzf.R;
import com.hzf.widget.TopBarView;

public abstract class BaseTopBarActivity extends BaseActivity {
    protected TopBarView topBarView;
    protected LayoutInflater layoutInflater;
    protected LinearLayout hzf_contentlay;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hzf_activity_topbar);
        layoutInflater = LayoutInflater.from(this);
        inited();
        onPreLoad();
        onCreateContentView();
        onFindView();
        onPostLoad();
    }
    
    public abstract void onPreLoad();
    
    public abstract void onCreateContentView();
    
    public abstract void onFindView();
    
    public abstract void onPostLoad();
    
    private void inited() {
        topBarView = (TopBarView)findViewById(R.id.hzf_topbarView);
        hzf_contentlay = (LinearLayout)findViewById(R.id.hzf_contentlay);
        
    }
    
    protected void setMainContentView(View view) {
        if (view == null) {
            return;
        }
        hzf_contentlay.removeAllViews();
        hzf_contentlay.addView(view);
    }
    
    protected void setMainContentView(int layoutResId) {
        if (layoutResId == 0) {
            return;
        }
        layoutInflater.inflate(layoutResId, hzf_contentlay);
    }
    
    public void setTitle(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        topBarView.hzf_tvTitle.setText(text);
    }
    
    public void setLeftBtnImg(int resId) {
        topBarView.hzf_leftBtn.setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0);
    }
    
    public void setRightBtnImg(int resId) {
        topBarView.hzf_rightBtn.setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0);
    }
    
}

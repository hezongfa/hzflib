package com.hzf.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzf.activity.BaseActivity;
import com.hzf.utils.print.FQL;

public abstract class BaseFragment extends Fragment {
    protected View contentView;
    protected BaseActivity baseActivity;
    
    public static <T> T newInstance(Context context, Class<T> clazz) {
        return newInstance(context, clazz, null);
    }
    
    public static <T> T newInstance(Context context, Class<T> clazz, Bundle args) {
        return (T)Fragment.instantiate(context, clazz.getName(), args);
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        FQL.d("onCreateView--");
        
        contentView = inflater.inflate(getLayout(), null);
        baseActivity = (BaseActivity)getActivity();
        return contentView;
    }
    
    @Override
    public void onViewCreated(View view, @Nullable
    Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
        FQL.d("onViewCreated--");
        inited();
    }
    
    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
    }
    
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    
    protected View findViewById(int id) {
        return contentView.findViewById(id);
    }
    
    protected View findViewWithTag(Object tag) {
        return contentView.findViewWithTag(tag);
    }
    
    protected void showLoading() {
        if (baseActivity != null) {
            baseActivity.showLoading();
        }
    }
    
    protected void closeLoading() {
        if (baseActivity != null) {
            baseActivity.closeLoading();
        }
    }
    
    protected boolean isVisible;
    
    protected abstract int getLayout();
    
    protected abstract void inited();
    
}

package com.hzf.activity;

import java.io.Serializable;
import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzf.R;
import com.hzf.fragment.BaseFragment;
import com.hzf.utils.print.FQL;

public abstract class BaseTabActivity extends BaseTopBarActivity {
    private LinearLayout hzf_layBottom;
    protected FragmentManager fragmentManager;
    private ArrayList<TabItem> tabItems;
    // private ArrayList<BaseFragment> fragments;
    private int clickIndex = -1;
    private View hzf_bottomline;
    private int presstextColorId = R.color.black;
    private int deftextColorId = R.color.gray_bcbcbc;
    private RelativeLayout bottomCenterExtraLay;
    
    // private ArrayList<String> fragmenttags;
    
    protected int getCurIndex() {
        return clickIndex;
    }
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.hzf_activity_bottomtab);
        
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            for (int i = 0; i < tabItems.size(); i++) {
                if (fragmentManager.getFragment(savedInstanceState, tabItems.get(i)
                    .getFragment()
                    .getClass()
                    .getSimpleName()) != null) {
                    tabItems.get(i).setFragment(((BaseFragment)fragmentManager.getFragment(savedInstanceState,
                        tabItems.get(i).getFragment().getClass().getSimpleName())));
                }
            }
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        // fragmenttags.clear();
        // for (int i = 0; i < tabItems.size(); i++) {
        // if (tabItems.get(i).getFragment() != null) {
        // fragmenttags.add(tabItems.get(i).getFragment().getClass()
        // .getSimpleName());
        // if (getSupportFragmentManager().findFragmentByTag(
        // tabItems.get(i).getFragment().getClass()
        // .getSimpleName()) == null) {
        // getSupportFragmentManager().putFragment(
        // outState,
        // tabItems.get(i).getFragment().getClass()
        // .getSimpleName(),
        // tabItems.get(i).getFragment());
        // }
        // }
        // }
    }
    
    @Override
    public void onPreLoad() {
        fragmentManager = getSupportFragmentManager();
        // fragmenttags = new ArrayList<>();
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        initBottomTab();
        if (tabItems.size() > 0) {
            witchContent(0);
        }
        inited();
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
        
    }
    
    protected LinearLayout getBottomLay() {
        return hzf_layBottom;
    }
    
    protected RelativeLayout getBottomCenterExtraLay() {
        return bottomCenterExtraLay;
    }
    
    protected void setBottomTabLineColor(int colorId) {
        hzf_bottomline.setBackgroundColor(resources.getColor(colorId));
    }
    
    protected void setBottomTabBgColor(int colorId) {
        hzf_layBottom.setBackgroundColor(resources.getColor(colorId));
    }
    
    protected void setBottomTabBgDrawable(int resid) {
        hzf_layBottom.setBackgroundResource(resid);
    }
    
    protected void setBottomTabTextColor(int defcolorId, int presscolorId) {
        deftextColorId = defcolorId;
        presstextColorId = presscolorId;
        for (int i = 0; i < tabItems.size(); i++) {
            TabItem tabItem = tabItems.get(i);
            if (clickIndex == tabItem.getIndex()) {
                tabItem.getTextView().setTextColor(resources.getColor(presstextColorId));
            } else {
                tabItem.getTextView().setTextColor(resources.getColor(deftextColorId));
            }
            
        }
    }
    
    private void initBottomTab() {
        hzf_layBottom = (LinearLayout)findViewById(R.id.hzf_layBottom);
        hzf_bottomline = findViewById(R.id.hzf_bottomline);
        tabItems = new ArrayList<BaseTabActivity.TabItem>();
        if (getTabItems() != null) {
            tabItems.addAll(getTabItems());
        }
        int centerIndex = 0;
        if (tabItems.size() % 2 == 0) {
            centerIndex = tabItems.size() / 2;
        }
        for (int i = 0; i < tabItems.size(); i++) {
            if (centerIndex == i) {
                // 在中间添加额外view
                bottomCenterExtraLay = new RelativeLayout(context);
                hzf_layBottom.addView(bottomCenterExtraLay);
            }
            LinearLayout view = (LinearLayout)layoutInflater.inflate(R.layout.hzf_bottomtab_item, null);
            LinearLayout.LayoutParams layoutParams =
                new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;
            view.setLayoutParams(layoutParams);
            TextView textView = (TextView)view.findViewById(R.id.hzf_tvTitle);
            textView.setText(tabItems.get(i).getTitle());
            textView.setTag(tabItems.get(i).getDefDrawableResId());
            textView.setCompoundDrawablesWithIntrinsicBounds(null,
                getResources().getDrawable(tabItems.get(i).getDefDrawableResId()),
                null,
                null);
            textView.setOnClickListener(new TabItemClick(i));
            hzf_layBottom.addView(view);
            tabItems.get(i).setIndex(i);
            tabItems.get(i).setTextView(textView);
            // fragments.add(tabItems.get(i).getFragment());
        }
    }
    
    class TabItemClick implements OnClickListener {
        int index;
        
        public TabItemClick(int index) {
            super();
            this.index = index;
        }
        
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            witchContent(index);
            onTabClick(index);
        }
        
    }
    
    protected void witchContent(int index) {
        if (clickIndex == -1) {
            clickIndex = index;
        }
        clickIndex = index;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (int i = 0; i < tabItems.size(); i++) {
            TabItem tabItem = tabItems.get(i);
            int topDrawableRes = 0;
            if (index == tabItem.getIndex()) {
                topDrawableRes = tabItem.getPressDrawableResId();
                tabItem.getTextView().setTextColor(resources.getColor(presstextColorId));
                if (fragmentManager.findFragmentByTag(tabItem.getFragment().getClass().getSimpleName()) == null) {
                    transaction.add(R.id.hzf_frameContent, tabItem.getFragment(), tabItem.getFragment()
                        .getClass()
                        .getSimpleName());
                    FQL.d("tabitems--getSimpleName--" + tabItem.getFragment().getClass().getSimpleName());
                    FQL.d("tabitems--getName--" + tabItem.getFragment().getClass().getName());
                }
                 transaction.show(tabItem.getFragment());
            } else {
                topDrawableRes = tabItem.getDefDrawableResId();
                tabItem.getTextView().setTextColor(resources.getColor(deftextColorId));
                 transaction.hide(tabItem.getFragment());
            }
            tabItem.getTextView().setCompoundDrawablesWithIntrinsicBounds(null,
                getResources().getDrawable(topDrawableRes),
                null,
                null);
        }
        topBarView.hzf_tvTitle.setText(tabItems.get(clickIndex).getTitle());
        // transaction.replace(R.id.hzf_frameContent, tabItems.get(index).getFragment(), tabItems.get(index)
        // .getFragment()
        // .getClass()
        // .getSimpleName());
        transaction.addToBackStack(tabItems.get(index).getFragment().getClass().getSimpleName());
        transaction.commit();
        
        // transaction.commitAllowingStateLoss();
    }
    
    public abstract void inited();
    
    public abstract ArrayList<TabItem> getTabItems();
    
    public abstract void onTabClick(int onclickIndex);
    
    public class TabItem implements Serializable {
        /**
		 * 
		 */
        private static final long serialVersionUID = 1L;
        private int defDrawableResId;
        private int pressDrawableResId;
        private String title;
        private BaseFragment fragment;
        
        private int index;
        private TextView textView;
        
        public TabItem(int defDrawableResId, int pressDrawableResId, String title, BaseFragment fragment) {
            super();
            this.defDrawableResId = defDrawableResId;
            this.pressDrawableResId = pressDrawableResId;
            this.title = title;
            this.fragment = fragment;
        }
        
        public TabItem() {
            super();
            // TODO Auto-generated constructor stub
        }
        
        public BaseFragment getFragment() {
            return fragment;
        }
        
        public void setFragment(BaseFragment fragment) {
            this.fragment = fragment;
        }
        
        public String getTitle() {
            return title;
        }
        
        public void setTitle(String title) {
            this.title = title;
        }
        
        public int getPressDrawableResId() {
            return pressDrawableResId;
        }
        
        public void setPressDrawableResId(int pressDrawableResId) {
            this.pressDrawableResId = pressDrawableResId;
        }
        
        public int getDefDrawableResId() {
            return defDrawableResId;
        }
        
        public void setDefDrawableResId(int defDrawableResId) {
            this.defDrawableResId = defDrawableResId;
        }
        
        public int getIndex() {
            return index;
        }
        
        public void setIndex(int index) {
            this.index = index;
        }
        
        public TextView getTextView() {
            return textView;
        }
        
        public void setTextView(TextView textView) {
            this.textView = textView;
        }
        
    }
    
}

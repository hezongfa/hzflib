package com.hzf.widget;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hzf.utils.SysUtil;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NoScrollWebView extends WebView {
    public NoScrollWebView(Context context) {
        super(context);
        
    }
    
    public NoScrollWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
    
    @TargetApi(Build.VERSION_CODES.KITKAT)
    class MyWebViewClient extends WebViewClient {
        boolean scaleChangedRunnablePending = false;
        
        // Other code here
        
        @Override
        public void onScaleChanged(final WebView webView, float oldScale, float newScale) {
            if (scaleChangedRunnablePending)
                return;
            NoScrollWebView.this.postDelayed(new Runnable() {
                @Override
                public void run() {
                    NoScrollWebView.this.evaluateJavascript("recalculateWidth();", null);
                    scaleChangedRunnablePending = false;
                }
            }, 100);
        }
    }
    
    /**
     * 设置加载进来的页面自适应手机屏幕
     */
    public void setSingleColumn() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.setWebViewClient(new MyWebViewClient());
            
        }
        WebSettings webSettings = getSettings();
//        webSettings.setLoadWithOverviewMode(true);
        // webSettings.setJavaScriptEnabled(true);
        // webSettings.setSupportZoom(true);
        // webSettings.setBuiltInZoomControls(true);
        // webSettings.setUseWideViewPort(true);
        webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
    }
    
    @Override
    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String failUrl) {
        // TODO Auto-generated method stub
        String content = "";
//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Document doc_Dis = Jsoup.parse(data);
//            Elements ele_Img = doc_Dis.getElementsByTag("img");
//            if (ele_Img.size() != 0) {
//                for (Element e_Img : ele_Img) {
//                    e_Img.attr("style", "width:100%");
//                }
//            }
//            content = doc_Dis.toString();
//        }
        content = data;
        super.loadDataWithBaseURL(baseUrl, content, mimeType, encoding, failUrl);
    }
}
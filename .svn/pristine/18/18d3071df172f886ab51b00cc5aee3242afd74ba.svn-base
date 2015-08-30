package com.hzf.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.hzf.R;
import com.hzf.app.App;
import com.hzf.utils.print.FQL;
import com.hzf.utils.print.FQT;
import com.hzf.widget.LoadingDialog;

public abstract class BaseActivity extends FragmentActivity {
    private LoadingDialog loadingDialog = null;
    protected Dialog dialog = null;
    protected boolean isexit = false;
    protected Resources resources;
    protected Context context;
    
    // 关于界面切换动画
    String startActMode = "";
    private static final String STARTACT_MODE = "STARTACT_MODE";
    private static final String STARTACT_MODE_PUSH = "STARTACT_MODE_PUSH";
    private static final String STARTACT_MODE_POP = "STARTACT_MODE_POP";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        App.addActivity(this);
        resources = getResources();
        context = this;
        startActMode = getIntent().getStringExtra(STARTACT_MODE);
        startActMode = startActMode == null ? "" : startActMode;
        if (startActMode.equals(STARTACT_MODE_PUSH)) {
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        } else if (startActMode.equals(STARTACT_MODE_POP)) {
            overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.alpha_to_background);
        }
    }
    
    @Override
    public void finish() {
        // TODO Auto-generated method stub
        super.finish();
        if (startActMode.equals(STARTACT_MODE_PUSH)) {
            overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        } else if (startActMode.equals(STARTACT_MODE_POP)) {
            overridePendingTransition(R.anim.alpha_to_front, R.anim.slide_out_to_bottom);
        }
    }
    
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }
    
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
    long temp = 0l;
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isexit) {
                if (System.currentTimeMillis() - temp < 2000) {
                    finish();
                    // android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(0);
                    App.exitClient(context);
                } else {
                    FQT.showShort(getApplicationContext(), "再按一次返回键退出");
                }
                temp = System.currentTimeMillis();
            } else {
                FQL.d("返回");
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        App.exitActivity(this);
        super.onDestroy();
    }
    
    protected void replaceContent(int layout, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(layout, fragment, fragment.getClass().getName());
        transaction.commit();
    }
    
    public void showAlert(String message, String ok, String no, OnClickListener okListener, OnClickListener noListener) {
        dialog = new AlertDialog.Builder(this)
        // .setIcon(android.R.drawable.stat_notify_error)
        .setTitle(getString(R.string.app_name))
            .setMessage(message)
            .setNeutralButton(ok, okListener)
            .setNegativeButton(no, noListener)
            .create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                dialog = null;
            }
        });
        dialog.show();
    }
    
    public void showErrorAlert(String errMessage) {
        dialog =
            new AlertDialog.Builder(this).setTitle(getString(R.string.app_name))
                .setMessage(errMessage)
                .setNeutralButton("确定", new OnClickListener() {
                    
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                dialog = null;
            }
        });
        dialog.show();
    }
    
    public void showTipsAlert(String errMessage, android.content.DialogInterface.OnClickListener o,
        boolean cancleByBackClick) {
        dialog =
            new AlertDialog.Builder(this).setTitle(getString(R.string.app_name))
                .setMessage(errMessage)
                .setNeutralButton("确定", o)
                .create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(cancleByBackClick);
        dialog.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                dialog = null;
            }
        });
        dialog.show();
    }
    
    public void showTipsAlert(String errMessage, android.content.DialogInterface.OnClickListener o) {
        dialog =
            new AlertDialog.Builder(this).setTitle(getString(R.string.app_name))
                .setMessage(errMessage)
                .setNeutralButton("确定", o)
                .create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                dialog = null;
            }
        });
        dialog.show();
    }
    
    public boolean hideKeyBoard() {
        if (getCurrentFocus() != null && getCurrentFocus() instanceof EditText) {
            ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
            getCurrentFocus().clearFocus();
            return true;
        } else {
            InputMethodManager inputMethodManager =
                ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE));
            if (inputMethodManager != null && inputMethodManager.isActive() && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            }
            return false;
        }
    }
    
    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(BaseActivity.this);
            
        } else {
            
        }
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }
    
    public void showLoading(String text) {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(BaseActivity.this);
            
        } else {
            
        }
        loadingDialog.setLoadingText(text);
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }
    
    public void closeLoading() {
        if (loadingDialog != null) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
                // loadingDialog = null;
            }
        }
    }
    
    public void setLoadingText(String string) {
        if (loadingDialog != null) {
            loadingDialog.setLoadingText(string);
        }
    }
    
    public void pushActivity(Intent intent) {
        pushActivityForResult(intent, 0);
    }
    
    public void pushActivityForResult(Intent intent, int requestCode) {
        intent.putExtra(STARTACT_MODE, STARTACT_MODE_PUSH);
        startActivityForResult(intent, requestCode);
    }
    
    public void popActivity(Intent intent) {
        popActivityForResult(intent, 0);
    }
    
    public void popActivityForResult(Intent intent, int requestCode) {
        intent.putExtra(STARTACT_MODE, STARTACT_MODE_POP);
        startActivityForResult(intent, requestCode);
    }
    
    public Intent getIntent(Class<? extends Activity> activity) {
        Intent intent = new Intent(this, activity);
        return intent;
    }
    
    public static Intent getPushNextIntent(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        return intent;
    }
    
}

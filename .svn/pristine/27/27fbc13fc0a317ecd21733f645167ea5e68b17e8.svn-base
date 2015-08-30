package com.hzf.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public class App extends Application {
    public static List<Activity> activityList = new ArrayList<Activity>();
    
    public static void exitClient(Context ctx) {
        // 关闭所有Activity
        for (int i = 0; i < activityList.size(); i++) {
            if (null != activityList.get(i)) {
                activityList.get(i).finish();
            }
        }
        ActivityManager activityMgr = (ActivityManager)ctx.getSystemService(Context.ACTIVITY_SERVICE);
        activityMgr.restartPackage(ctx.getPackageName());
        System.exit(0);
    }
    
    public static <T extends Activity> void addActivity(T act) {
        if (!activityList.contains(act)) {
            activityList.add(act);
        }
    }
    
    public static <T extends Activity> void exitActivity(T act) {
        if (!act.isFinishing()) {
            act.finish();
        }
        if (activityList.contains(act)) {
            activityList.remove(act);
        }
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
    }
    
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        
    }
    
    @Override
    public void onLowMemory() {
        // TODO Auto-generated method stub
        super.onLowMemory();
    }
    
    @Override
    public void onTerminate() {
        // TODO Auto-generated method stub
        super.onTerminate();
    }
    
}

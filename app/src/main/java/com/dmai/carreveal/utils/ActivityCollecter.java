package com.dmai.carreveal.utils;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityCollecter {
    public static ArrayList<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void removeAllActivity(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

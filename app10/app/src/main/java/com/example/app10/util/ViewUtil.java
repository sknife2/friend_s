package com.example.app10.util;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewUtil {
    public  static  void hideOneInputMethod(Activity activity , View view){
        //系统服务中获取输入法管理器
        InputMethodManager inputMethodManager= (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        //关闭屏幕输入法软键盘
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}

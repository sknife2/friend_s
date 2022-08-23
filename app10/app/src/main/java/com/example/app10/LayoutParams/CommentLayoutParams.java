package com.example.app10.LayoutParams;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class CommentLayoutParams extends ViewGroup.LayoutParams {
    public static final int POSITION_CENTER = 0;        // 中间
    public static final int POSITION_LEFT = 1;          // 左侧
    public static final int POSITION_RIGHT = 2;         // 右侧
    public static final int POSITION_TOP = 3;           // 上侧
    public static final int POSITION_BOTTOM = 4;        // 下侧
    public static final int POSITION_LEFT_TOP = 5;      // 左上方
    public static final int POSITION_RIGHT_TOP = 6;     // 右上方
    public static final int POSITION_LEFT_BOTTOM = 7;   // 左下方
    public static final int POSITION_RIGHT_BOTTOM = 8;  // 右下方
    public int POSITION = POSITION_CENTER;              // 默认位置为中间

    public CommentLayoutParams(Context c, AttributeSet attrs) {
        super(c, attrs);
    }

    public CommentLayoutParams(int width, int height) {
        super(width, height);
    }

    public CommentLayoutParams(ViewGroup.LayoutParams source) {
        super(source);
    }
}

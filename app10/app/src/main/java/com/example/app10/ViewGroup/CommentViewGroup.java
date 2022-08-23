package com.example.app10.ViewGroup;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.app10.R;

import java.util.ArrayList;
import java.util.List;

public class CommentViewGroup extends ViewGroup {
    private int mWidth;
    private int mHeight;
    List<Integer> listHeight = new ArrayList<>();
    List<List<View>> listLineView = new ArrayList<>();
    private Context mContext;

    public CommentViewGroup(Context context) {
        this(context, null);
    }

    public CommentViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.mContext = context;
    }

    public CommentViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //MeasureSpec 封装了32位二进制，前两位是mode
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        /**
         * 子控件得到宽高
         */
        int childWidth = 0;
        int childHeight = 0;
        /**
         * @param usedWidth
         * 当前viewgroup 已使用的宽高
         */
        int usedWidth = 0;
        int usedHeight = 0;
        /**
         * 子控件宽高
         */
        int iChildWidth = 0;
        int iChildHeight = 0;

        if (widthMode == MeasureSpec.EXACTLY) {

        } else if (widthMode == MeasureSpec.AT_MOST) {

        }
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.EXACTLY) {

        } else if (heightMode == MeasureSpec.AT_MOST) {

        }
        //调用子Measure
        // 保存测量的最终结果
        setMeasuredDimension(widthSize, heightSize);

    }

    //当View要为所有子对象分配大小和位置时，调用此方法
    @Override
    protected void onLayout(boolean change, int left, int top, int right, int bottom) {

    }

    //这个方法是用来想View容器中添加组件用的.
    @Override
    public void addView(View child) {
        super.addView(child);
    }

    //这个方法用来返回指定位置的View。
    @Override
    public View getChildAt(int index) {
        return super.getChildAt(index);
    }

    private int getWindowWidthPixels() {
        Resources resources = mContext.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        return width;
    }
}

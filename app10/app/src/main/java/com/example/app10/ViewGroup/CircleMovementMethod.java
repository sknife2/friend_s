package com.example.app10.ViewGroup;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class CircleMovementMethod implements MovementMethod {
    private final static int DEFAULT_COLOR_ID = android.R.color.transparent;
    /**
     * 整个textView的背景色
     */
    private int textViewBgColor;
    /**
     * 点击部分文字时部分文字的背景色
     */
    private int clickableSpanBgClor;
    private BackgroundColorSpan mBgSpan;
    private ClickableSpan[] mClickLinks;

    /**
     * @param clickableSpanBgClor 点击选中部分时的背景色
     */
    public CircleMovementMethod(int clickableSpanBgClor) {
        this.clickableSpanBgClor = clickableSpanBgClor;
    }

    /**
     * @param clickableSpanBgClor 点击选中部分时的背景色
     * @param textViewBgColor     整个textView点击时的背景色
     */
    public CircleMovementMethod(int clickableSpanBgClor, int textViewBgColor) {
        this.textViewBgColor = textViewBgColor;
        this.clickableSpanBgClor = clickableSpanBgClor;
    }

    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            x -= widget.getTotalPaddingLeft();
            y -= widget.getTotalPaddingTop();
            x += widget.getScrollX();
            y += widget.getScrollY();
            Layout layout = widget.getLayout();
            int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);
            mClickLinks = buffer.getSpans(off, off, ClickableSpan.class);
            if (mClickLinks.length>0){
// 点击的是Span区域，不要把点击事件传递
                Selection.setSelection(buffer,
                        buffer.getSpanStart(mClickLinks[0]),
                        buffer.getSpanEnd(mClickLinks[0]));
//设置点击区域的背景色
                mBgSpan = new BackgroundColorSpan(clickableSpanBgClor);
                buffer.setSpan(mBgSpan,
                        buffer.getSpanStart(mClickLinks[0]),
                        buffer.getSpanEnd(mClickLinks[0]),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else{
// textview选中效果
//    widget.setBackgroundColor(textViewBgColor);
                widget.setBackgroundResource(DEFAULT_COLOR_ID);
            }
        } else if (action == MotionEvent.ACTION_UP) {
            if (mClickLinks.length> 0){
                mClickLinks[0].onClick(widget);
                if (mBgSpan != null) {//移除点击时设置的背景span
                    buffer.removeSpan(mBgSpan);
                }
            } else{
            }
            Selection.removeSelection(buffer);
            widget.setBackgroundResource(DEFAULT_COLOR_ID);
        } else if (action == MotionEvent.ACTION_MOVE) {
//这种情况不用做处理
        } else {
            if (mBgSpan != null) {//移除点击时设置的背景span
                buffer.removeSpan(mBgSpan);
            }
            widget.setBackgroundResource(DEFAULT_COLOR_ID);
        }
        return Touch.onTouchEvent(widget, buffer, event);
    }

    @Override
    public boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean canSelectArbitrarily() {
        return false;
    }

    @Override
    public void initialize(TextView textView, Spannable spannable) {

    }

    @Override
    public boolean onKeyDown(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public boolean onKeyUp(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public void onTakeFocus(TextView textView, Spannable spannable, int i) {

    }

    @Override
    public boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }
}

package com.example.app10.ViewGroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.app10.R;
import com.example.app10.util.UserBean;

import java.util.List;

public class CommentsView extends View {
    private Rect mTextBounds;
    private Paint mPaint;
    private String text;
    private Context mContext;
    private List<CommentsBean> mDatas;
    private int mWidth;
    private int mHeight;

    public CommentsView(Context context) {
        this(context, null);
    }

    public CommentsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //setOrientation(VERTICAL); Linearlayout
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommentsView);
        String first_person=typedArray.getString(R.styleable.CommentsView_first_person);
        String Second_person=typedArray.getString(R.styleable.CommentsView_second_person);
        String Message =typedArray.getString(R.styleable.CommentsView_message);
        if(Second_person ==null){
            text=first_person+":"+Message;
        }else{
            text=first_person+"回复:"+Second_person+Message;
        }
        text = typedArray.getString(R.styleable.CommentsView_first_person);
        typedArray.recycle();//必须调用recycle()
        mPaint = new Paint();
        mTextBounds = new Rect();
        mPaint.setTextSize(50);
        mPaint.getTextBounds(text, 0, text.length(), mTextBounds);
        this.mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text, getPaddingLeft(), getPaddingBottom()+mTextBounds.height(), mPaint); //*******

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {//match_parent or 具体数值
            mWidth = specWidth;
        } else if (specMode == MeasureSpec.AT_MOST) {// wrap_content
            mWidth = mTextBounds.width()+getPaddingLeft()+getPaddingRight();//"文字大小";
        }
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specHeight = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {//match_parent or 具体数值
            mHeight = specHeight+getPaddingTop()+getPaddingBottom();
        } else if (specMode == MeasureSpec.AT_MOST) {// wrap_content
            mHeight = mTextBounds.height();//"文字大小";
        }
        setMeasuredDimension(mWidth,mHeight);
    }

    /**
     * 设置评论列表信息
     */
    public void setList(List<CommentsBean> list) {
        mDatas = list;
    }
    /*public void notifyDataSetChanged() {
        removeAllViews();
        if (mDatas == null || mDatas.size() <= 0) {
            return;
        }
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 10, 0, 10);
        for (int i = 0; i < mDatas.size(); i++) {
            View view = getView(i);
            if (view == null) {
                throw new NullPointerException("listview item layout is null, please check getView()...");
            }
            addView(view, i, layoutParams);
        }
    }
*/
    /*private View getView(final int position) {
        final CommentsBean item = mDatas.get(position);
        UserBean replyUser = item.getReplyUser();
        boolean hasReply = false; // 是否有回复
        if (replyUser != null) {
            hasReply = true;
        }
        TextView textView = new TextView(mContext);
        textView.setTextSize(15);
        textView.setTextColor(0xff686868);
        SpannableStringBuilder builder = new SpannableStringBuilder();
        UserBean comUser = item.getCommentsUser();
        String name = comUser.getUserName();
        if (hasReply) {
            builder.append(setClickableSpan(name, item.getCommentsUser()));
            builder.append(" 回复 ");
            builder.append(setClickableSpan(replyUser.getUserName(), item.getReplyUser()));
        } else {
            builder.append(setClickableSpan(name, item.getCommentsUser()));
        }
        builder.append(" : ");
        builder.append(setClickableSpanContent(item.getContent(), position));
        textView.setText(builder);
        // 设置点击背景色
        textView.setHighlightColor(getResources().getColor(android.R.color.transparent));
        //  textView.setHighlightColor(0xff000000);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position, item);
                }
            }
        });
        return textView;
    }
*/
    /**
     * 设置评论内容点击事件
     */
    public SpannableString setClickableSpanContent(final String item, final int position) {
        final SpannableString string = new SpannableString(item);
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
//  评论内容点击事件
                Toast.makeText(mContext, "position: " + position + " , content: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
// 设置显示的内容文本颜色
                ds.setColor(0xff686868);
                ds.setUnderlineText(false);
            }
        };
        string.setSpan(span, 0, string.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return string;
    }

    /**
     * 设置评论用户名字点击事件
     *
     * @param item
     * @param bean
     * @return string
     */
    public SpannableString setClickableSpan(final String item, final UserBean bean) {
        final SpannableString string = new SpannableString(item);
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
// 评论用户名字点击事件
                Toast.makeText(mContext, bean.getUserName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
// 设置显示的用户名文本颜色
                ds.setColor(0xff387dcc);
                ds.setUnderlineText(false);
            }
        };
        string.setSpan(span, 0, string.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return string;
    }

}

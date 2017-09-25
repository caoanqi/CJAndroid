package com.tpwalk.cjdroid.widget.expand;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * 折叠布局 触摸滑动
 * Created by Administrator on 2017/9/22.
 */

public class TouchExpandLayout extends ExpandLayout {
    private GestureDetector mScrollGestureDetector;

    public TouchExpandLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        mScrollGestureDetector = new GestureDetector(context, new ScrollGestureDetector());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mScrollGestureDetector.onTouchEvent(event);
    }

    private int mTranslation = -1;

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (mTranslation == -1)
            mTranslation = getWidth();
        super.dispatchDraw(canvas);
    }

    class ScrollGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            mTranslation -= distanceX;

            if (mTranslation < 0) {
                mTranslation = 0;
            }
            if (mTranslation > getWidth()) {
                mTranslation = getWidth();
            }

            float factor = Math.abs(((float) mTranslation) / ((float) getWidth()));
            setFactor(factor);

            return true;
        }
    }

}

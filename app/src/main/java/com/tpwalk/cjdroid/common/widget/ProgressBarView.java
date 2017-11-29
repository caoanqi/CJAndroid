package com.tpwalk.cjdroid.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.utils.DensityUtils;

/**
 * 自定义进度条
 * Created by jerry on 2017/7/8.
 */

public class ProgressBarView extends View {

  private Context mContext;
  int barColor = Color.parseColor("#1e88e5");
  int hSpace = DensityUtils.dip2px(mContext, 80);
  int vSpace = DensityUtils.dip2px(mContext, 4);

  int space = DensityUtils.dip2px(mContext, 10);
  float startX = 0;
  float delta = 10f;
  Paint mPaint;

  int index = 0;

  public ProgressBarView(Context context) {
    this(context, null);
  }

  public ProgressBarView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ProgressBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mContext = context;
    TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.rainbowbar, 0, 0);

    hSpace = typedArray.getDimensionPixelSize(R.styleable.rainbowbar_rainbowbar_hspace, hSpace);
    vSpace = typedArray.getDimensionPixelSize(R.styleable.rainbowbar_rainbowbar_vspace, vSpace);

    barColor = typedArray.getColor(R.styleable.rainbowbar_rainbowbar_color, barColor);
    typedArray.recycle();

    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setColor(barColor);
    mPaint.setStrokeWidth(vSpace);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    float sw = this.getMeasuredWidth();

    if (startX >= sw + (hSpace + space) - (sw % (hSpace + space))) {
      startX = 0;
    } else {
      startX += delta;
    }
    float start = startX;

    while (start < sw) {
      canvas.drawLine(start, 5, start + hSpace, 5, mPaint);
      start += (hSpace + space);
    }

    start = startX - space - hSpace;

    while (start >= -hSpace) {
      canvas.drawLine(start, 5, start + hSpace, 5, mPaint);
      start -= (hSpace + space);
    }
    if (index >= 700000) {
      index = 0;
    }
    invalidate();

  }
}

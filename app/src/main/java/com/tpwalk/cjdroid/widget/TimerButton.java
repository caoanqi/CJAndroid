package com.tpwalk.cjdroid.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by caoyoulin on 2017/8/23.
 */

public class TimerButton extends AppCompatButton implements View.OnClickListener {

  /*默认倒计时长*/
  private long countDownLength = 60 * 1000;

  /*未点击之前的显示的文字*/
  private String beforeText = "获取验证码";

  /*倒计时结束后获取*/
  private String refreshText = "重新获取";

  /**
   * 开始执行计时的类，可以在每秒实行间隔任务
   */
  private Timer timer;

  /**
   * 在开始倒计时之后那个秒数数字之后所要显示的字，默认是秒
   */
  private String afterText = "秒";

  /**
   * 按钮点击事件
   */
  private OnClickListener onClickListener;

  /**
   * 每秒时间到了之后所执行的任务
   */
  private TimerTask timerTask;

  public TimerButton(Context context) {
    this(context, null);
  }

  public TimerButton(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public TimerButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    if (!TextUtils.isEmpty(getText())) {
      beforeText = getText().toString().trim();
    }
    this.setText(beforeText);
    this.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    start();
    if (onClickListener != null) {
      onClickListener.onClick(view);
    }
  }

  /**
   * 设置监听按钮点击事件
   */
  @Override
  public void setOnClickListener(OnClickListener onclickListener) {
    if (onclickListener instanceof TimerButton) {
      super.setOnClickListener(onclickListener);
    } else {
      this.onClickListener = onclickListener;
    }
  }

  /**
   * 开始倒计时
   */
  public void start() {
    initTimer();
    this.setText(countDownLength / 1000 + afterText);
    this.setEnabled(false);
    timer.schedule(timerTask, 0, 1000);
  }

  /**
   * 初始化时间
   */
  private void initTimer() {
    timer = new Timer();
    timerTask = new TimerTask() {
      @Override
      public void run() {
        mMyHandler.sendEmptyMessage(1);
      }
    };
  }

  /**
   * 设置倒计时时长
   *
   * @param length 默认毫秒
   */
  public void setLength(long length) {
    this.countDownLength = length;
  }

  /**
   * 设置未点击时显示的文字
   */
  public void setBeforeText(String beforeText) {
    this.beforeText = beforeText;
  }

  /**
   * 设置未点击后显示的文字
   */
  public void setAfterText(String beforeText) {
    this.afterText = afterText;
  }

  /**
   * 更新显示的文本
   */
  @SuppressLint("HandlerLeak")
  private Handler mMyHandler = new Handler() {

    @SuppressLint("SetTextI18n")
    @Override
    public void handleMessage(Message msg) {
      super.handleMessage(msg);
      TimerButton.this.setText(countDownLength / 1000 + afterText);
      countDownLength -= 1000;
      if (countDownLength < 0) {
        TimerButton.this.setEnabled(true);
        TimerButton.this.setText(refreshText);
        clearTimer();
        countDownLength = 60 * 1000;
      }
    }
  };


  /**
   * 清除倒计时
   */
  private void clearTimer() {
    if (timerTask != null) {
      timerTask.cancel();
      timerTask = null;
    }
    if (timer != null) {
      timer.cancel();
      timer = null;
    }
  }

  /**
   * 在界面销毁后调用，否则有内存泄漏风险
   */
  @Override
  protected void onDetachedFromWindow() {
    clearTimer();
    super.onDetachedFromWindow();
  }

}
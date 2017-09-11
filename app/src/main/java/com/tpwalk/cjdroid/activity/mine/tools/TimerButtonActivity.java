package com.tpwalk.cjdroid.activity.mine.tools;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityTimerButtonBinding;

public class TimerButtonActivity extends BaseActivity {

    ActivityTimerButtonBinding mActivityTimerButtonBinding;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        super.initContentView(savedInstanceState);
        mActivity = this;
        mActivityTimerButtonBinding = DataBindingUtil.setContentView(this, R.layout.activity_timer_button);

    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected void initData() {
        super.initData();
        setToolbarTitle("计时器按钮");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();

    }
}

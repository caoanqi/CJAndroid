package com.tpwalk.cjdroid.activity.setting;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivitySettingBinding;

public class SettingActivity extends BaseActivity {

    ActivitySettingBinding activitySettingBinding;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        super.initContentView(savedInstanceState);
        mActivity = this;
        activitySettingBinding = DataBindingUtil.setContentView(this, R.layout.activity_setting);

    }

    @Override
    protected void initListener() {
        super.initListener();
        activitySettingBinding.appVersionUpdateRl.setOnClickListener(v -> {

        });
    }
}

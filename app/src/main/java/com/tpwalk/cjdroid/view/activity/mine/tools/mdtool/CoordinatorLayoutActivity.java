package com.tpwalk.cjdroid.view.activity.mine.tools.mdtool;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityCoordinatorLayoutBinding;

public class CoordinatorLayoutActivity extends BaseActivity {

    ActivityCoordinatorLayoutBinding activityCoordinatorLayoutBinding;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        super.initContentView(savedInstanceState);
        mActivity = this;
        activityCoordinatorLayoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_coordinator_layout);
    }

    @Override
    protected void initData() {
        super.initData();
        setToolbarTitle("折叠");
    }

    @Override
    protected void initView() {
        super.initView();
    }


}

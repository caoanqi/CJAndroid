package com.tpwalk.cjdroid.view.activity.mine;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.view.activity.mine.tools.TimerButtonActivity;
import com.tpwalk.cjdroid.view.activity.mine.tools.anim.AnimaitonActivity;
import com.tpwalk.cjdroid.view.activity.mine.tools.citys.CityChooseActivity;
import com.tpwalk.cjdroid.view.activity.mine.tools.citys.LocationActivity;
import com.tpwalk.cjdroid.view.activity.mine.tools.dialogs.MyDialogActivity;
import com.tpwalk.cjdroid.view.activity.mine.tools.share.MyShareActivity;
import com.tpwalk.cjdroid.view.activity.mine.tools.tab.TabActivity;
import com.tpwalk.cjdroid.view.activity.mine.tools.webs.QQWebViewActivity;
import com.tpwalk.cjdroid.view.activity.news.CommentsActivity;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityMyToolsBinding;
import com.tpwalk.cjdroid.view.activity.video.VideoViewActivity;

public class MyToolsActivity extends BaseActivity {

    ActivityMyToolsBinding activityMyToolsBinding;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        super.initContentView(savedInstanceState);
        mActivity = this;
        activityMyToolsBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_tools);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
        activityMyToolsBinding.rlShare.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, MyShareActivity.class)));
        activityMyToolsBinding.rlCityChoose.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, CityChooseActivity.class)));

        activityMyToolsBinding.btnComment.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, CommentsActivity.class)));
        activityMyToolsBinding.btnFlingAnim.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, AnimaitonActivity.class)));

        activityMyToolsBinding.btnWebView.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, QQWebViewActivity.class)));
        activityMyToolsBinding.bdMapView.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, LocationActivity.class)));

        activityMyToolsBinding.btnDialog.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, MyDialogActivity.class)));
        activityMyToolsBinding.btnTab.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, TabActivity.class)));
        activityMyToolsBinding.btTimer.setOnClickListener(
                v -> startActivity(new Intent().setClass(this, TimerButtonActivity.class)));

        activityMyToolsBinding.btVideo.setOnClickListener(v ->
                startActivity(new Intent().setClass(this, VideoViewActivity.class)));
    }
}

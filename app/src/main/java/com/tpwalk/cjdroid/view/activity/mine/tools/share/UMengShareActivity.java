package com.tpwalk.cjdroid.view.activity.mine.tools.share;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityUmengShareBinding;

public class UMengShareActivity extends BaseActivity {

  ActivityUmengShareBinding activityUmengShareBinding;

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);
    mActivity = this;
    activityUmengShareBinding = DataBindingUtil.setContentView(this, R.layout.activity_umeng_share);
  }

  @Override
  protected void initData() {
    super.initData();
    setToolbarTitle("友盟分享");
  }

  @Override
  protected void initListener() {
    super.initListener();
  }
}

package com.tpwalk.cjdroid.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityMyShareBinding;

public class MyShareActivity extends BaseActivity {

  ActivityMyShareBinding activityMyShareBinding;

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);
    mActivity=this;
    activityMyShareBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_share);
  }

  @Override
  protected void initData() {
    super.initData();
    setToolbarTitle("分享");
  }

  @Override
  protected void initListener() {
    super.initListener();
    activityMyShareBinding.btnIntentShare.setOnClickListener(v -> intentShare());
    activityMyShareBinding.btnUmengShare.setOnClickListener(v -> umengShare());

  }

  private void intentShare() {
    Intent intent_share = new Intent();
    intent_share.setAction(Intent.ACTION_SEND);
    intent_share.setType("text/plain");
    intent_share.putExtra(Intent.EXTRA_SUBJECT, "分享渠道");
    intent_share.putExtra(Intent.EXTRA_TEXT, " Hello 分型");

    intent_share = Intent.createChooser(intent_share, "分享标题");
    startActivity(intent_share);

  }

  private void umengShare() {

  }
}

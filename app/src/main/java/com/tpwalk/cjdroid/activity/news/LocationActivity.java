package com.tpwalk.cjdroid.activity.news;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.baidu.mapapi.SDKInitializer;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityLocationBinding;

/**
 * 定位
 */
public class LocationActivity extends BaseActivity {

  ActivityLocationBinding activityLocationBinding;

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);
    //在使用SDK各组件之前初始化context信息，传入ApplicationContext
    //注意该方法要再setContentView方法之前实现
    SDKInitializer.initialize(getApplicationContext());
    mActivity = this;

    activityLocationBinding = DataBindingUtil.setContentView(this, R.layout.activity_location);

  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  protected void initData() {
    super.initData();
    setToolbarTitle("百度地图");


  }
}

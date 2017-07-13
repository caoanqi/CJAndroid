package com.tpwalk.cjdroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.activity.MainActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * activity 基类
 * Created by Administrator on 2017/6/23.
 */

public class BaseActivity extends RxAppCompatActivity {

  protected Activity mActivity;
  private Toolbar mToolbar;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initContentView(savedInstanceState);
    if (!mActivity.getClass().getSimpleName().equals(MainActivity.class.getSimpleName())) {
      initToolbar();
    }
    initView();
    initListener();
    initData();
  }

  protected void initContentView(Bundle savedInstanceState) {

  }

  protected void initToolbar() {
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mToolbar.setNavigationIcon(R.drawable.ic_navigation_back);

    setSupportActionBar(mToolbar);
    mToolbar.setNavigationOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  protected void setToolbarTitle(String title) {
    mToolbar.setTitle(title);
  }

  protected void initView() {
  }

  protected void initListener() {

  }

  protected void initData() {
  }

  protected void onBindingData() {

  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }
}

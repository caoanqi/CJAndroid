package com.tpwalk.cjdroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.tpwalk.cjdroid.R;

/**
 * activity 基类
 * Created by Administrator on 2017/6/23.
 */

public class BaseActivity extends AppCompatActivity {

    private Activity mActivity;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(savedInstanceState);
        initToolbar();
        initView();
        initListener();
        initData();
    }

    protected void initContentView(Bundle savedInstanceState) {

    }

    protected void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    protected void setToolbarTitle() {

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

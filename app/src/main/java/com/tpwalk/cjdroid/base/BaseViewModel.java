package com.tpwalk.cjdroid.base;

import android.app.Activity;
import android.content.Intent;

/**
 * view model 基类
 * Created by Administrator on 2017/6/23.
 */

public class BaseViewModel implements IViewModel {
    protected Activity mActivity;


    protected void initAll() {
        initView();
        initListener();
        initData();
    }

    protected void initData() {
    }

    protected void initView() {
    }

    protected void initListener() {
    }

    protected void onBindingData() {
    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}

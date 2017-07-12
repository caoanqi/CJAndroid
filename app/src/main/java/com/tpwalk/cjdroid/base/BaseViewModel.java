package com.tpwalk.cjdroid.base;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ViewDataBinding;

/**
 * view model 基类
 * Created by Administrator on 2017/6/23.
 */

public abstract class BaseViewModel implements IViewModel {
    protected Activity mActivity;
    ViewDataBinding dataBinding;

    protected void initAll() {
  
        initView();
        initListener();
        initData();
    }

    protected abstract void initData();
    protected abstract void initView() ;
    protected abstract void initListener() ;

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

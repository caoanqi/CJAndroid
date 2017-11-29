package com.tpwalk.cjdroid.view.activity.mine.tools.webs;


import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityQqwebViewBinding;

/**
 * QQ浏览器
 * x5内核
 */
public class QQWebViewActivity extends BaseActivity {

  ActivityQqwebViewBinding activityQqwebViewBinding;

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);
    mActivity = this;
    activityQqwebViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_qqweb_view);
  }

  @Override
  protected void initView() {
    super.initView();
    initWebView();
  }

  @Override
  protected void initListener() {
    super.initListener();
  }

  @Override
  protected void initData() {
    super.initData();
    setToolbarTitle("QQ浏览器");
  }

  @SuppressLint("SetJavaScriptEnabled")
  private void initWebView() {
    // TODO Auto-generated method stub
    String url = "http://www.baidu.com";
    activityQqwebViewBinding.qqWeb.loadUrl(url);
    com.tencent.smtt.sdk.WebSettings webSettings = activityQqwebViewBinding.qqWeb.getSettings();
    webSettings.setJavaScriptEnabled(true);
    activityQqwebViewBinding.qqWeb.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });

  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && activityQqwebViewBinding.qqWeb.canGoBack()) {
      activityQqwebViewBinding.qqWeb.goBack();// 返回前一个页面
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }
}

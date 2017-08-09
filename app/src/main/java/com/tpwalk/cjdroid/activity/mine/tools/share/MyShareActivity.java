package com.tpwalk.cjdroid.activity.mine.tools.share;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityMyShareBinding;
import com.tpwalk.cjdroid.utils.AppUtils;
import java.util.ArrayList;
import java.util.List;

public class MyShareActivity extends BaseActivity {

  ActivityMyShareBinding activityMyShareBinding;

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);
    mActivity = this;
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
    activityMyShareBinding.btnUmengShare.setOnClickListener(
        v -> startActivity(new Intent().setClass(MyShareActivity.this, UMengShareActivity.class)));
    activityMyShareBinding.btnHrowserShare.setOnClickListener(v -> openBrowserShare());

  }

  private void openBrowserShare() {

    if (AppUtils.isInstallApp(MyShareActivity.this, "com.tencent.mtt")) {
      Intent it = new Intent();
      it.setAction("android.intent.action.VIEW");
      Uri content_url = Uri.parse("http://m.riztz.com/fx/demo.html");
      it.setData(content_url);
      it.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
      startActivity(it);

//      Intent intent = new Intent();
//      intent.setAction("android.intent.action.VIEW");
//      Uri content_url = Uri.parse("http://m.riztz.com/fx/demo.html");
//      intent.setData(content_url);
//      startActivity(intent);
    } else {
      Toast.makeText(MyShareActivity.this, "没有安装，请安装QQ浏览器", Toast.LENGTH_SHORT).show();
    }


  }

  private void intentShare() {
    // region 1

//    Intent intent_share = new Intent();
//    intent_share.setAction(Intent.ACTION_SEND);
//    intent_share.setType("text/plain");
//    intent_share.putExtra(Intent.EXTRA_SUBJECT, "分享渠道");
//    intent_share.putExtra(Intent.EXTRA_TEXT, " Hello 分型");
//
//    intent_share = Intent.createChooser(intent_share, "分享标题");
//    startActivity(intent_share);

    // endregion

    // region 2

    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
// 查询所有可以分享的Activity
    List<ResolveInfo> resInfo = MyShareActivity.this.getPackageManager()
        .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
    if (!resInfo.isEmpty()) {
      List<Intent> targetedShareIntents = new ArrayList<>();
      for (ResolveInfo info : resInfo) {
        Intent targeted = new Intent(Intent.ACTION_SEND);
        targeted.setType("text/plain");
        ActivityInfo activityInfo = info.activityInfo;
        Log.v("logcat", "packageName=" + activityInfo.packageName + "Name=" + activityInfo.name);
        // 分享出去的内容
        targeted.putExtra(Intent.EXTRA_TEXT, "这是我的分享内容" + getPackageName());
        // 分享出去的标题
        targeted.putExtra(Intent.EXTRA_SUBJECT, "主题");
        targeted.setPackage(activityInfo.packageName);
        targeted.setClassName(activityInfo.packageName, info.activityInfo.name);
        PackageManager pm = MyShareActivity.this.getApplication().getPackageManager();
        // 微信有2个怎么区分-。- 朋友圈还有微信
        if (info.activityInfo.applicationInfo.loadLabel(pm).toString().equals("微信")) {
          targetedShareIntents.add(targeted);
        }
      }
      // 选择分享时的标题
      Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0), "选择分享");
      if (chooserIntent == null) {
        return;
      }
      chooserIntent
          .putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.toArray(new Parcelable[]{}));
      try {
        startActivity(chooserIntent);
      } catch (android.content.ActivityNotFoundException ex) {

        Toast.makeText(this, "找不到该分享应用组件", Toast.LENGTH_SHORT).show();
      }
    }

    //endregion
  }

}

package com.tpwalk.cjdroid.activity.mine.tools.citys;

import android.Manifest.permission;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityLocationBinding;
import com.tpwalk.cjdroid.utils.DeviceUtils;
import java.util.UUID;

/**
 * 定位
 */
public class LocationActivity extends BaseActivity {

  ActivityLocationBinding activityLocationBinding;

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);

    mActivity = this;
    activityLocationBinding = DataBindingUtil.setContentView(this, R.layout.activity_location);

  }

  @Override
  protected void initView() {
    super.initView();

//普通地图
//   activityLocationBinding.bmapView.getMap().setMapType(BaiduMap.MAP_TYPE_NORMAL);

//卫星地图
//    activityLocationBinding.bmapView.getMap().setMapType(BaiduMap.MAP_TYPE_SATELLITE);

//空白地图, 基础地图瓦片将不会被渲染。在地图类型中设置为NONE，将不会使用流量下载基础地图瓦片图层。使用场景：与瓦片图层一起使用，节省流量，提升自定义瓦片图下载速度。
//    mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @SuppressLint("HardwareIds")
  @Override
  protected void initData() {
    super.initData();
    setToolbarTitle("百度地图");
    TelephonyManager tm = (TelephonyManager) getBaseContext()
        .getSystemService(Context.TELEPHONY_SERVICE);
    if (ActivityCompat.checkSelfPermission(this, permission.READ_PHONE_STATE)
        != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling
      //    ActivityCompat#requestPermissions
      // here to request the missing permissions, and then overriding
      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
      //                                          int[] grantResults)
      // to handle the case where the user grants the permission. See the documentation
      // for ActivityCompat#requestPermissions for more details.
      return;
    } else {
//      权限请求
//      requestPermissions();
    }
    String androidId = "" + android.provider.Settings.Secure
        .getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
    String tmDevice = "" + tm.getDeviceId();
    String tmSerial = "" + tm.getSimSerialNumber();
    UUID deviceUuid = new UUID(androidId.hashCode(),
        ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());

    activityLocationBinding.tvDeviceId.setText(
        DeviceUtils.getAndroidID(this) + "\n" +
            DeviceUtils.getMacAddress(this) + "\n" +
            "TM:" + tm.getDeviceId() + "\n" +
            "SM:" + tm.getSimSerialNumber() + "\n" +
            "androdId：" + androidId + "\n" +
            "uuid：" + deviceUuid.toString());
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);


  }
}

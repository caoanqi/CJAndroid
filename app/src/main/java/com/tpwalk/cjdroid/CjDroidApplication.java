package com.tpwalk.cjdroid;

import android.app.Service;
import android.os.Vibrator;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import com.baidu.mapapi.SDKInitializer;
import com.tencent.smtt.sdk.QbSdk;
import com.tpwalk.cjdroid.service.LocationService;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by caoyoulin on 2017/6/23.
 */

public class CjDroidApplication extends MultiDexApplication {

  public LocationService locationService;

  public Vibrator mVibrator;
  @Override
  public void onCreate() {
    super.onCreate();

    initRelam();
    initQQWebKit();
    initBdMap();


  }

  /**
   * 初始化地图
   */
  private void initBdMap() {
    /***
     * 初始化定位sdk，建议在Application中创建
     */
    locationService = new LocationService(getApplicationContext());
    mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
    SDKInitializer.initialize(getApplicationContext());
  }

  /*
  methond name: $NAME
  date:$DATE
  remark:$DESC
  */
  private void initRelam() {
    Realm.init(this);
    RealmConfiguration configuration = new RealmConfiguration.Builder().build();
    Realm.deleteRealm(configuration);
    Realm.setDefaultConfiguration(configuration);
  }


  /**
   * 初始化qq web view
   */
  private void initQQWebKit() {
    //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。

    QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

      @Override
      public void onCoreInitFinished() {
        // TODO Auto-generated method stub
      }

      @Override
      public void onViewInitFinished(boolean b) {
        // TODO Auto-generated method stub
        //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
        Log.d("app", " onViewInitFinished is " + b);
      }


    };
    //x5内核初始化接口
    QbSdk.initX5Environment(getApplicationContext(), cb);
  }
}

package com.tpwalk.cjdroid;

import android.support.multidex.MultiDexApplication;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**

 * Created by caoyoulin on 2017/6/23.
 */

public class CjDroidApplication extends MultiDexApplication {

  @Override
  public void onCreate() {
    super.onCreate();

    initRelam();

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
}

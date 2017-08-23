package com.tpwalk.cjdroid.citypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;


public class BaiduMapActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_baidu_map);
    MapView mapView=(MapView)findViewById(R.id.bd_map_view);
    mapView.getMap().setMapType(BaiduMap.MAP_TYPE_NORMAL);
  }
}

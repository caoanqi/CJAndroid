package com.tpwalk.cjdroid.citypicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.tpwalk.cjdroid.citypicker.adapter.CityListWithoutHotAdapter;
import com.tpwalk.cjdroid.citypicker.adapter.ResultListAdapter;
import com.tpwalk.cjdroid.citypicker.db.DBManager;
import com.tpwalk.cjdroid.citypicker.model.City;
import com.tpwalk.cjdroid.citypicker.model.LocateState;
import com.tpwalk.cjdroid.citypicker.utils.StringUtils;
import com.tpwalk.cjdroid.citypicker.view.SideLetterBarWithoutHot;
import java.util.List;

/**
 * 城市选择无热门城市
 * 采用百度地图
 */
public class CityPickerWithoutHotActivity extends AppCompatActivity implements
    View.OnClickListener {

  public static final String KEY_PICKED_CITY = "picked_city";

  private ListView mListView;
  private ListView mResultListView;
  private SideLetterBarWithoutHot mLetterBar;
  private EditText searchBox;
  private ImageView clearBtn;
  private ImageView backBtn;
  private ViewGroup emptyView;

  private CityListWithoutHotAdapter mCityAdapter;
  private ResultListAdapter mResultAdapter;
  private List<City> mAllCities;
  private DBManager dbManager;

  private LocationClient mLocationClient;
  private LocationClientOption option;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cp_activity_city_with_out_hot_list);
    initData();
    initView();
    initLocation();
  }

  private void initLocation() {
    mLocationClient = new LocationClient(getApplicationContext());
    option = new LocationClientOption();
    option.setLocationMode(
        LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
    option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
    option.setScanSpan(3000);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
    option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
    option.setIsNeedLocationDescribe(true);//可选，设置是否需要地址描述
    option.setNeedDeviceDirect(false);//可选，设置是否需要设备方向结果
    option.setLocationNotify(false);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
    option
        .setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
    option.setIsNeedLocationDescribe(
        true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
    option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
    option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
    option.setIsNeedAltitude(false);//可选，默认false，设置定位时是否需要海拔信息，默认不需要，除基础定位版本都可用
    mLocationClient.setLocOption(option);

    mLocationClient.registerLocationListener(locListener);
    mLocationClient.start();
  }

  BDLocationListener locListener = new BDLocationListener() {
    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
      if (bdLocation != null) {
        if (bdLocation.getLocType() != BDLocation.TypeServerError) {
          mLocationClient.stop();
          String city = bdLocation.getCity();
          String district = bdLocation.getDistrict();
          final String location = StringUtils.extractLocation(city, district);

          runOnUiThread(new Runnable() {
            @Override
            public void run() {
              mCityAdapter.updateLocateState(LocateState.SUCCESS, location);
            }
          });
        } else {
          //定位失败
          mCityAdapter.updateLocateState(LocateState.FAILED, null);
        }
      }
    }

    @Override
    public void onConnectHotSpotMessage(String s, int i) {

    }


  };


  private void initData() {
    dbManager = new DBManager(this);
    dbManager.copyDBFile();
    mAllCities = dbManager.getAllCities();
    mCityAdapter = new CityListWithoutHotAdapter(this, mAllCities);
    mCityAdapter.setOnCityClickListener(new CityListWithoutHotAdapter.OnCityClickListener() {
      @Override
      public void onCityClick(String name) {
        back(name);
      }

      @Override
      public void onLocateClick() {
        mCityAdapter.updateLocateState(LocateState.LOCATING, null);
//        mLocationClient.start();
      }
    });

    mResultAdapter = new ResultListAdapter(this, null);
  }

  private void initView() {
    mListView = (ListView) findViewById(R.id.listview_all_city);
    mListView.setAdapter(mCityAdapter);

    TextView overlay = (TextView) findViewById(R.id.tv_letter_overlay);
    mLetterBar = (SideLetterBarWithoutHot) findViewById(R.id.side_letter_bar);
    mLetterBar.setOverlay(overlay);
    mLetterBar.setOnLetterChangedListener(new SideLetterBarWithoutHot.OnLetterChangedListener() {
      @Override
      public void onLetterChanged(String letter) {
        int position = mCityAdapter.getLetterPosition(letter);
        mListView.setSelection(position);

      }
    });

    searchBox = (EditText) findViewById(R.id.et_search);
    searchBox.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }

      @Override
      public void afterTextChanged(Editable s) {
        String keyword = s.toString();
        if (TextUtils.isEmpty(keyword)) {
          clearBtn.setVisibility(View.GONE);
          emptyView.setVisibility(View.GONE);
          mResultListView.setVisibility(View.GONE);
        } else {
          clearBtn.setVisibility(View.VISIBLE);
          mResultListView.setVisibility(View.VISIBLE);
          List<City> result = dbManager.searchCity(keyword);
          if (result == null || result.size() == 0) {
            emptyView.setVisibility(View.VISIBLE);
          } else {
            emptyView.setVisibility(View.GONE);
            mResultAdapter.changeData(result);
          }
        }
      }
    });

    emptyView = (ViewGroup) findViewById(R.id.empty_view);
    mResultListView = (ListView) findViewById(R.id.listview_search_result);
    mResultListView.setAdapter(mResultAdapter);
    mResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        back(mResultAdapter.getItem(position).getName());
      }
    });

    clearBtn = (ImageView) findViewById(R.id.iv_search_clear);
    backBtn = (ImageView) findViewById(R.id.back);

    clearBtn.setOnClickListener(this);
    backBtn.setOnClickListener(this);
  }

  private void back(String city) {
    Intent data = new Intent();
    data.putExtra(KEY_PICKED_CITY, city);
    setResult(RESULT_OK, data);
    finish();
  }

  @Override
  public void onClick(View v) {
    int i = v.getId();
    if (i == R.id.iv_search_clear) {
      searchBox.setText("");
      clearBtn.setVisibility(View.GONE);
      emptyView.setVisibility(View.GONE);
      mResultListView.setVisibility(View.GONE);
    } else if (i == R.id.back) {
      finish();

    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mLocationClient.stop();
  }
}

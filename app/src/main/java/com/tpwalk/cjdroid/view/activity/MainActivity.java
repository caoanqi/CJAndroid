package com.tpwalk.cjdroid.view.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.TextView;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.adapters.MainViewPagerAdapter;
import com.tpwalk.cjdroid.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private TextView mTextMessage;
    private ViewPager mViewPagerMainContent;
    private BottomNavigationView navigation;
    private String permissionInfo;
    private final int SDK_PERMISSION_REQUEST = 127;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPagerMainContent.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPagerMainContent.setCurrentItem(1);

                    return true;
                case R.id.navigation_notifications:
                    mViewPagerMainContent.setCurrentItem(2);

                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        super.initContentView(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        getPersimmions();
    }

    @Override
    protected void initView() {
        super.initView();
        mViewPagerMainContent = (ViewPager) findViewById(R.id.vp_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }

    @Override
    protected void initListener() {
        super.initListener();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPagerMainContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    navigation.setSelectedItemId(R.id.navigation_home);

                } else if (position == 1) {
                    navigation.setSelectedItemId(R.id.navigation_dashboard);

                } else if (position == 2) {
                    navigation.setSelectedItemId(R.id.navigation_notifications);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mViewPagerMainContent.setAdapter(mainViewPagerAdapter);
    }

    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            /*
			 * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
			 */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
            }
            // 读取电话状态权限
            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
    }

    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)) {
                return true;
            } else {
                permissionsList.add(permission);
                return false;
            }

        } else {
            return true;
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // TODO Auto-generated method stub
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    private void initViewPager() {

    }

}

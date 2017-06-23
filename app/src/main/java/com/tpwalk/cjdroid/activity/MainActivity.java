package com.tpwalk.cjdroid.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.adapters.MainViewPagerAdapter;
import com.tpwalk.cjdroid.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private TextView mTextMessage;
    private ViewPager mViewPagerMainContent;
    private BottomNavigationView navigation;

    private MainViewPagerAdapter mainViewPagerAdapter;

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
            }
            return false;
        }
    };

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        super.initContentView(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mViewPagerMainContent.setAdapter(mainViewPagerAdapter);
    }

    private void initViewPager() {

    }

}

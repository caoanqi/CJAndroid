package com.tpwalk.cjdroid.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.tpwalk.cjdroid.view.fragment.VideoFragment;
import com.tpwalk.cjdroid.view.fragment.NewsFragment;
import com.tpwalk.cjdroid.view.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Main 适配器
 * Created by Administrator on 2017/6/23.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments.add(NewsFragment.newInstance());
        mFragments.add(VideoFragment.newInstance());
        mFragments.add(MineFragment.newInstance());
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}

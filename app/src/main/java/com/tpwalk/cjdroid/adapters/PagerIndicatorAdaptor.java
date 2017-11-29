package com.tpwalk.cjdroid.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tpwalk.cjdroid.view.fragment.NewsScrollPagerFragment;

/**
 * Created by caoyoulin on 2017/7/12.
 */

public class PagerIndicatorAdaptor extends FragmentPagerAdapter {
    protected static final String[] CONTENT = new String[] { "This", "Is", "A", "Test", };
    private int mCount = CONTENT.length;

    public PagerIndicatorAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return NewsScrollPagerFragment.newInstance(CONTENT[position % CONTENT.length]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PagerIndicatorAdaptor.CONTENT[position % CONTENT.length];
    }


    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}
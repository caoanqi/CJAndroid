package com.tpwalk.cjdroid.activity.mine.tools.tab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tpwalk.cjdroid.R;

/**
 * Created by caoyoulin on 2017/8/11.
 */

public class CustomerTabAdapter extends FragmentPagerAdapter {

  private Context mContext;
  private FragmentManager mFragmentManager;
  private final int pageCount = 3;
  private String[] tabTitles = new String[]{"请选择1", "请选择2", "请选择3"};
  int[] imgIds = {R.drawable.ic_next_right, R.drawable.ic_next_right, R.drawable.ic_next_right};

  public CustomerTabAdapter(FragmentManager fm) {
    super(fm);
  }

  public CustomerTabAdapter(FragmentManager fm, Context context) {
    super(fm);
    mContext = context;
    mFragmentManager = fm;
  }

  @Override
  public Fragment getItem(int i) {
    return null;
  }

  @Override
  public int getCount() {
    return pageCount;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return super.getPageTitle(position);
  }

  public View getTabView(int position) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.tab_item, null);
    TextView tv = (TextView) view.findViewById(R.id.textView);
    tv.setText(tabTitles[position]);
    ImageView img = (ImageView) view.findViewById(R.id.imageView);
    img.setImageResource(imgIds[position]);
    return view;
  }
}

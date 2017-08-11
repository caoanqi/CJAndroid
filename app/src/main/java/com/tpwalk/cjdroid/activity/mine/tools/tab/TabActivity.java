package com.tpwalk.cjdroid.activity.mine.tools.tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityTabBinding;

public class TabActivity extends BaseActivity {

  ActivityTabBinding activityTabBinding;
  private String[] tabTitles = new String[]{"请选择1", "请选择2", "请选择3"};
  int[] imgIds = {R.drawable.ic_next_right, R.drawable.ic_next_right, R.drawable.ic_next_right};

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);
    activityTabBinding = DataBindingUtil.setContentView(this, R.layout.activity_tab);
  }

  @Override
  protected void initView() {
    super.initView();

    activityTabBinding.tabLayout.setTabMode(TabLayout.MODE_FIXED);
    for (int i = 0; i < activityTabBinding.tabLayout.getTabCount(); i++) {
      TabLayout.Tab tab = activityTabBinding.tabLayout.getTabAt(i);
      tab.setCustomView(getTabView(i));
    }
  }


  @Override
  protected void initData() {
    super.initData();
  }

  public View getTabView(int position) {
    View view = LayoutInflater.from(this).inflate(R.layout.tab_item, null);
    TextView tv = (TextView) view.findViewById(R.id.textView);
    tv.setText(tabTitles[position]);
    ImageView img = (ImageView) view.findViewById(R.id.imageView);
    img.setImageResource(imgIds[position]);
    return view;
  }
}

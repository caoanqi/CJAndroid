package com.tpwalk.cjdroid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tpwalk.cjdroid.activity.webs.QQWebViewActivity;
import com.tpwalk.cjdroid.base.BaseFragment;
import com.tpwalk.cjdroid.databinding.FragmentDashboardBinding;

/**
 * 功能表盘
 * Created by Administrator on 2017/6/23.
 */

public class DashboardFragment extends BaseFragment {

  public DashboardFragment() {

  }

  FragmentDashboardBinding dashboardBinding;

  public static DashboardFragment newInstance() {
    return new DashboardFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false);
    return dashboardBinding.getRoot();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    dashboardBinding.btnWebView
        .setOnClickListener(v -> startActivity(new Intent().setClass(getContext(),
            QQWebViewActivity.class)));
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

  }
}

package com.tpwalk.cjdroid.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tpwalk.cjdroid.base.BaseFragment;
import com.tpwalk.cjdroid.databinding.FragmentDashboardBinding;

/**
 * 功能表盘
 * Created by Administrator on 2017/6/23.
 */

public class VideoFragment extends BaseFragment {

  public VideoFragment() {

  }

  FragmentDashboardBinding dashboardBinding;

  public static VideoFragment newInstance() {
    return new VideoFragment();
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

  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

  }
}

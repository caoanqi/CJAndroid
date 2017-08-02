package com.tpwalk.cjdroid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tpwalk.cjdroid.activity.share.MyShareActivity;
import com.tpwalk.cjdroid.activity.setting.SettingActivity;
import com.tpwalk.cjdroid.base.BaseFragment;
import com.tpwalk.cjdroid.databinding.FragmentNotificationBinding;

/**
 * 消息通知
 * Created by Administrator on 2017/6/23.
 */

public class MineFragment extends BaseFragment {

  public MineFragment() {
  }

  public static MineFragment newInstance() {
    return new MineFragment();
  }

  FragmentNotificationBinding fragmentNotificationBinding;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    fragmentNotificationBinding = FragmentNotificationBinding.inflate(inflater, container, false);
    return fragmentNotificationBinding.getRoot();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    fragmentNotificationBinding.rlSetting.setOnClickListener(
        v -> startActivity(new Intent().setClass(getActivity(), SettingActivity.class)));
    fragmentNotificationBinding.rlShare.setOnClickListener(
        v -> startActivity(new Intent().setClass(getActivity(), MyShareActivity.class)));


  }
}

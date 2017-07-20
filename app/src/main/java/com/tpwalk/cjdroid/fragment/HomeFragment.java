package com.tpwalk.cjdroid.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.activity.CommentsActivity;
import com.tpwalk.cjdroid.activity.anim.AnimaitonActivity;
import com.tpwalk.cjdroid.adapters.PagerIndicatorAdaptor;
import com.tpwalk.cjdroid.base.BaseFragment;
import com.tpwalk.cjdroid.databinding.FragmentHomeBinding;

/**
 * 首页
 * Created by Administrator on 2017/6/23.
 */

public class HomeFragment extends BaseFragment {

  FragmentHomeBinding fragmentHomeBinding;
  PagerIndicatorAdaptor pagerIndicatorAdaptor;

  public HomeFragment() {

  }

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    fragmentHomeBinding = DataBindingUtil
        .inflate(inflater, R.layout.fragment_home, container, false);
    return fragmentHomeBinding.getRoot();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    fragmentHomeBinding.btnComment.setOnClickListener(
        v -> startActivity(new Intent().setClass(getContext(), CommentsActivity.class)));
    fragmentHomeBinding.btnFlingAnim
        .setOnClickListener(v -> startActivity(new Intent().setClass(getContext(),
            AnimaitonActivity.class)));
    initData();
  }

  @Override
  protected void initData() {
    super.initData();
    pagerIndicatorAdaptor = new PagerIndicatorAdaptor(getChildFragmentManager());
    fragmentHomeBinding.homeViewPager.setAdapter(pagerIndicatorAdaptor);
    fragmentHomeBinding.homeCirclePageIndicator.setViewPager(fragmentHomeBinding.homeViewPager);
  }
}

package com.tpwalk.cjdroid.viewmodel;

import android.app.Activity;

import com.tpwalk.cjdroid.adapters.CommentsAdapter;
import com.tpwalk.cjdroid.base.BaseViewModel;
import com.tpwalk.cjdroid.databinding.ActivityCommentsBinding;
import com.tpwalk.dllibrary.impl.CommentServicesImpl;
import com.tpwalk.dllibrary.model.CommentsModel;

import java.util.List;

/**
 * 评论逻辑
 * Created by Administrator on 2017/6/23.
 */

public class CommentsViewModel extends BaseViewModel {

    private ActivityCommentsBinding activityCommentsBinding;
    private CommentsAdapter commentsAdapter;
    private List<CommentsModel.CommentsBean> commentsBeanList;

    public CommentsViewModel(ActivityCommentsBinding activityCommentsBinding, Activity activity) {

        this.activityCommentsBinding = activityCommentsBinding;
        this.mActivity = activity;

        initAll();
    }

    @Override
    protected void initData() {
        super.initData();
        CommentsModel commentsModel = CommentServicesImpl.getCommentsAll(mActivity);
        if (commentsModel != null) {
            commentsBeanList = commentsModel.getComments();
            onBindingData();
        }
    }

    @Override
    protected void onBindingData() {
        super.onBindingData();
        commentsAdapter = new CommentsAdapter(commentsBeanList,mActivity);
        activityCommentsBinding.rvComments.setAdapter(commentsAdapter);
    }
}

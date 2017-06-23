package com.tpwalk.cjdroid.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityCommentsBinding;
import com.tpwalk.cjdroid.viewmodel.CommentsViewModel;

public class CommentsActivity extends BaseActivity {

    ActivityCommentsBinding activityCommentsBinding;
    CommentsViewModel commentsViewModel;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        super.initContentView(savedInstanceState);

        activityCommentsBinding = DataBindingUtil.setContentView(this, R.layout.activity_comments);
        commentsViewModel = new CommentsViewModel(activityCommentsBinding, this);
        activityCommentsBinding.setViewModel(commentsViewModel);
    }

}

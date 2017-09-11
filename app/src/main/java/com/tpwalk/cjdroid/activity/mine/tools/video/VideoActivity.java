package com.tpwalk.cjdroid.activity.mine.tools.video;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.util.Log;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.activity.mine.tools.video.content.RecentMediaStorage;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityVideoBinding;
import com.tpwalk.cjdroid.widget.video.Settings;
import com.tpwalk.cjdroid.widget.video.widget.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;


public class VideoActivity extends BaseActivity {
    private static final String TAG = "VideoActivity";

    ActivityVideoBinding activityVideoBinding;

    private Uri mVideoUri;
    private String mVideoPath;
    private Settings mSettings;

    public static Intent newIntent(Context context, String videoPath, String videoTitle) {
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("videoPath", videoPath);
        intent.putExtra("videoTitle", videoTitle);
        return intent;
    }

    public static void intentTo(Context context, String videoPath, String videoTitle) {
        context.startActivity(newIntent(context, videoPath, videoTitle));
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        super.initContentView(savedInstanceState);
        mActivity = this;
        activityVideoBinding = DataBindingUtil.setContentView(this, R.layout.activity_video);


    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected void initData() {
        super.initData();
        setToolbarTitle("视频");

//        SpannableString spannableString = new SpannableString("我很好你那");
//        ImageSpan span = new ImageSpan(this, R.drawable.cp_search_box_bg, DynamicDrawableSpan.ALIGN_BASELINE);
//        spannableString.setSpan(span, 3, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        activityVideoBinding.tvTest.setText(spannableString);

//        mVideoPath = "/storage/emulated/0/DCIM/Camera/VID_20170830_103158.mp4";
//
//        new RecentMediaStorage(this).saveUrlAsync(mVideoPath);


        mSettings = new Settings(this);
        mVideoPath = "/storage/emulated/0/DCIM/Camera/VID_20170830_103158.mp4";
        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        activityVideoBinding.ijkVideoView.setVideoPath(mVideoPath);

        activityVideoBinding.ijkVideoView.setHudView(activityVideoBinding.hudView);
        activityVideoBinding.ijkVideoView.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

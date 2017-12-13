package com.tpwalk.cjdroid.view.activity.video;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;

import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.databinding.ActivityVideoViewBinding;

/**
 * 视频
 *
 * @author caoyl
 */
public class VideoViewActivity extends AppCompatActivity {

    private ActivityVideoViewBinding activityVideoViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityVideoViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_video_view);
        activityVideoViewBinding.videoView.setMediaController(new MediaController(this));

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.test);
        activityVideoViewBinding.videoView.setVideoURI(uri);
        activityVideoViewBinding.videoView.start();
        activityVideoViewBinding.videoView.requestFocus();
    }
}

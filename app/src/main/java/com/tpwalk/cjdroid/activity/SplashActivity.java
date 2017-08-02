package com.tpwalk.cjdroid.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.tpwalk.cjdroid.R;

public class SplashActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    new Handler().postDelayed(() -> {
      finish();
      startActivity(new Intent().setClass(SplashActivity.this, MainActivity.class));
    }, 3000);

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

  }
}

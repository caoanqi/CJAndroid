package com.tpwalk.cjdroid.view.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tpwalk.cjdroid.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * @author caoyl
 */

@RuntimePermissions
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


    @NeedsPermission(Manifest.permission.READ_PHONE_STATE)
    void showReadPhoneState() {
    }

    @OnShowRationale(Manifest.permission.READ_PHONE_STATE)
    void onShowRationaleForReadPhoneState(final PermissionRequest request) {
    }
}

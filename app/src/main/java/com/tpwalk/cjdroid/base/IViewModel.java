package com.tpwalk.cjdroid.base;

import android.content.Intent;

/**
 * Created by Administrator on 2017/6/23.
 */

public interface IViewModel {

    void onRestart();

    void onDestroy();

    void onPause();

    void onResume();

    void onStop();

    void onActivityResult(int requestCode, int resultCode, Intent data);

}

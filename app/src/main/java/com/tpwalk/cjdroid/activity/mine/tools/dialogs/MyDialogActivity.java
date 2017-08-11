package com.tpwalk.cjdroid.activity.mine.tools.dialogs;

import android.os.Bundle;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityMyDialogBinding;

public class MyDialogActivity extends BaseActivity {

  ActivityMyDialogBinding mActivityMyDialogBinding;

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);
    setContentView(R.layout.activity_my_dialog);

  }
}

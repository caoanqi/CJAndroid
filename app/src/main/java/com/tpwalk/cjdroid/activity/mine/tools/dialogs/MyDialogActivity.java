package com.tpwalk.cjdroid.activity.mine.tools.dialogs;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.activity.mine.tools.dialogs.CustomDialog.OnDialogListener;
import com.tpwalk.cjdroid.base.BaseActivity;
import com.tpwalk.cjdroid.databinding.ActivityMyDialogBinding;

public class MyDialogActivity extends BaseActivity {

  ActivityMyDialogBinding mActivityMyDialogBinding;

  @Override
  protected void initContentView(Bundle savedInstanceState) {
    super.initContentView(savedInstanceState);
    mActivity = this;
    mActivityMyDialogBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_dialog);
//    mActivityMyDialogBinding.setViewModel(new MyDialogViewModel(this));

  }

  @Override
  protected void initData() {
    super.initData();
    setToolbarTitle("Dialog");
  }

  @Override
  protected void initListener() {
    super.initListener();

    mActivityMyDialogBinding.btnHalfTranceDialog.setOnClickListener(v -> showCustomDialog());
  }

  private void showLoginDialog() {
    //创建Dialog并设置样式主题
    SelectDialog selectDialog = new SelectDialog(this, R.style.my_half_trans_dialog);

    selectDialog.setCanceledOnTouchOutside(true);//设置点击Dialog外部任意区域关闭Dialog
    selectDialog.show();
  }


  private void showCustomDialog() {
    new CustomDialog(MyDialogActivity.this,
        R.layout.dialog_custom,
        new OnDialogListener() {
          @Override
          public void onUnRegisterLogin() {

          }

          @Override
          public void onRegisterAndIdCardLogin() {

          }

          @Override
          public void onRegisterAndProvidentFundLogin() {

          }

          @Override
          public void onRegisterLogin() {

          }

          @Override
          public void onCancel(Dialog dialog) {
            if (dialog.isShowing()) {
              dialog.dismiss();
            }
          }
        })
        .show();

  }

}

package com.tpwalk.cjdroid.activity.mine.tools.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

    mActivityMyDialogBinding.btnHalfTranceDialog.setOnClickListener(v -> dialog4());
  }

  private void showLoginDialog() {
    //创建Dialog并设置样式主题
    SelectDialog selectDialog = new SelectDialog(this, R.style.my_half_trans_dialog);

    selectDialog.setCanceledOnTouchOutside(true);//设置点击Dialog外部任意区域关闭Dialog
    selectDialog.show();
  }


  private void showCustomDialog() {
    new CustomDialog(MyDialogActivity.this,
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

  /**
   * 列表对话框
   */
  private void dialog4() {
    String items[] = {"item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8"};
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("列表对话框").setItems(items, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        //TODO 实现自己的需求
      }
    }).show();

//    AlertDialog alertDialog=builder.create();
//    alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//    alertDialog.show();
  }

}

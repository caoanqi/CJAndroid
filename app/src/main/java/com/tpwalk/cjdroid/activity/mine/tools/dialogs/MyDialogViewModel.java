package com.tpwalk.cjdroid.activity.mine.tools.dialogs;

import android.app.Activity;
import com.tpwalk.cjdroid.R;

/**
 * Created by caoyoulin on 2017/8/11.
 */

public class MyDialogViewModel {

  private Activity mActivity;

  MyDialogViewModel(Activity activity) {
    mActivity = activity;
  }


  public void showHalfTranceDialog() {
//    ToastUtils.showShortToast(mActivity, "hello dialog");
    showLoginDialog();
  }

  private void showLoginDialog() {
    //创建Dialog并设置样式主题
    SelectDialog selectDialog = new SelectDialog(mActivity, R.style.my_half_trans_dialog);
    selectDialog.setCanceledOnTouchOutside(true);//设置点击Dialog外部任意区域关闭Dialog
    selectDialog.show();
  }

}

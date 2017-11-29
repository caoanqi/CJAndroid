package com.tpwalk.cjdroid.view.activity.mine.tools.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import com.tpwalk.cjdroid.R;

/**
 * Created by caoyoulin on 2017/8/11.
 */

public class SelectDialog extends AlertDialog {


  protected SelectDialog(Context context) {
    super(context);
  }

  protected SelectDialog(Context context, int themeResId) {
    super(context, themeResId);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.select_login_type_dialog);
  }
}

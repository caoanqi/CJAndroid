package com.tpwalk.cjdroid.activity.mine.tools.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;
import com.tpwalk.cjdroid.R;

/**
 * Created by caoyoulin on 2017/8/11.
 */

public class CustomDialog extends Dialog {


  private OnDialogListener mOnDialogListener;

  private int mLayoutId;
  Button btnUnRegisterLogin;
  Button btnRegisterIdCardLogin;
  Button btnRegisterProvidentFundLogin;
  Button btnRegisterLogin;
  Button btnDialogCancel;

  public CustomDialog(@NonNull Context context) {
    super(context);
  }

  public CustomDialog(@NonNull Context context, int themeResId) {
    super(context, themeResId);
  }

  /**
   * 构造方法
   *
   * @param onDialogListener 点击Dialog确定对应的监听器
   */
  public CustomDialog(Context context, int layoutId, OnDialogListener onDialogListener) {
    super(context, R.style.my_half_trans_dialog);
    mLayoutId = layoutId;
    mOnDialogListener = onDialogListener;
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(mLayoutId);

    btnUnRegisterLogin = (Button) findViewById(R.id.btn_un_register_login);
    btnRegisterIdCardLogin = (Button) findViewById(R.id.btn_register_id_card_login);
    btnRegisterProvidentFundLogin = (Button) findViewById(R.id.btn_register_provident_fund_login);
    btnRegisterLogin = (Button) findViewById(R.id.btn_register_login);
    btnDialogCancel = (Button) findViewById(R.id.btn_dialog_cancel);

    btnUnRegisterLogin.setOnClickListener(v -> mOnDialogListener.onUnRegisterLogin());
    btnRegisterIdCardLogin.setOnClickListener(v -> mOnDialogListener.onRegisterAndIdCardLogin());
    btnRegisterProvidentFundLogin.setOnClickListener(
        v -> mOnDialogListener.onRegisterAndProvidentFundLogin());
    btnRegisterLogin.setOnClickListener(v -> mOnDialogListener.onRegisterLogin());
    btnDialogCancel.setOnClickListener(v -> mOnDialogListener.onCancel(this));

  }


  //点击确定对应的监听器
  public interface OnDialogListener {

    /**
     * 未注册用户登录
     */
    void onUnRegisterLogin();

    /**
     * 注册用户,身份证登录
     */
    void onRegisterAndIdCardLogin();

    /**
     * 注册用户,公积金账号登录
     */
    void onRegisterAndProvidentFundLogin();

    /**
     * 注册用户,用户名登录
     */
    void onRegisterLogin();

    void onCancel(Dialog dialog);
  }

}

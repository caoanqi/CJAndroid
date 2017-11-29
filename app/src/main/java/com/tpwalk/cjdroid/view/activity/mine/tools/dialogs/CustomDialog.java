package com.tpwalk.cjdroid.view.activity.mine.tools.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.tpwalk.cjdroid.R;

/**
 * Created by caoyoulin on 2017/8/11.
 */

public class CustomDialog extends Dialog {


  private OnDialogListener mOnDialogListener;

  private Context context;

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
  public CustomDialog(Context context, OnDialogListener onDialogListener) {
    super(context, R.style.my_half_trans_dialog);
    mOnDialogListener = onDialogListener;
    this.context = context;
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    init();
  }

  private void init() {
    //以view的方式引入，然后回调activity方法，setContentView，实现自定义布局
    View view = LayoutInflater.from(context).inflate(R.layout.dialog_custom, null);
    setContentView(view);

    Button btnUnRegisterLogin = (Button) findViewById(R.id.btn_un_register_login);
    Button btnRegisterIdCardLogin = (Button) findViewById(R.id.btn_register_id_card_login);
    Button btnRegisterProvidentFundLogin = (Button) findViewById(
        R.id.btn_register_provident_fund_login);
    Button btnRegisterLogin = (Button) findViewById(R.id.btn_register_login);
    Button btnDialogCancel = (Button) findViewById(R.id.btn_dialog_cancel);

    btnUnRegisterLogin.setOnClickListener(v -> mOnDialogListener.onUnRegisterLogin());
    btnRegisterIdCardLogin.setOnClickListener(v -> mOnDialogListener.onRegisterAndIdCardLogin());
    btnRegisterProvidentFundLogin
        .setOnClickListener(v -> mOnDialogListener.onRegisterAndProvidentFundLogin());
    btnRegisterLogin.setOnClickListener(v -> mOnDialogListener.onRegisterLogin());
    btnDialogCancel.setOnClickListener(v -> mOnDialogListener.onCancel(this));

    //设置dialog大小，这里是一个小赠送，模块好的控件大小设置
    Window dialogWindow = getWindow();
    WindowManager manager = ((Activity) context).getWindowManager();
    WindowManager.LayoutParams params = dialogWindow.getAttributes(); // 获取对话框当前的参数值
    dialogWindow.setGravity(Gravity.CENTER);//设置对话框位置
    Display d = manager.getDefaultDisplay(); // 获取屏幕宽、高度
    params.width = d.getWidth(); // 宽度设置为屏幕的0.65，根据实际情况调整
    params.height = d.getHeight();
    dialogWindow.setAttributes(params);

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

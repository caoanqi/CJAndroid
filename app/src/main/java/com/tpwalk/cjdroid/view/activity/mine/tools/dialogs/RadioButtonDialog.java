package com.tpwalk.cjdroid.view.activity.mine.tools.dialogs;

import android.content.Context;
import android.widget.RadioGroup;

/**
 * Created by jerry on 2017/8/13.
 */

public class RadioButtonDialog extends BaseDialog {

  private Context context;
  private String title;
  private OnItemCheckListener onItemCheckListener;

  public RadioButtonDialog(Context context) {
    super(context);
    this.context = context;
  }

  public RadioButtonDialog(Context context, int theme) {
    super(context, theme);
  }

  //回调这个方法啦
  @Override
  public int getLayoutId() {
    return 0;
  }

  //也回调了父类的init，利用getLayoutId传入了布局的id
  @Override
  protected void init() {
    super.init();

//    RadioGroup groupBroadcast = (RadioGroup) view.findViewById(R.id.groupBroadcast);
//    groupBroadcast.setOnCheckedChangeListener(listener);
  }

  private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
      onItemCheckListener.onItemCheck(checkedId);
    }
  };

  public interface OnItemCheckListener {

    void onItemCheck(int checkedId);
  }

}

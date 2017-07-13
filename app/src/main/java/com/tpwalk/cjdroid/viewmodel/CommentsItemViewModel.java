package com.tpwalk.cjdroid.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import com.tpwalk.dllibrary.model.CommentsModel.CommentsBean;

/**
 * 评论内容
 * Created by caoyoulin on 2017/7/13.
 */

public class CommentsItemViewModel {

  private Context context;
  public ObservableField<String> author = new ObservableField<>();
  public ObservableField<String> content = new ObservableField<>();
  public ObservableField<String> headerImage = new ObservableField<>();

  public CommentsItemViewModel(Context context, CommentsBean commentsBean) {

    this.context = context;
    initData(commentsBean);
  }

  private void initData(CommentsBean commentsBean) {
    author.set(commentsBean.getAuthor());
    content.set(commentsBean.getContent());
    headerImage.set(commentsBean.getAvatar());
  }

}

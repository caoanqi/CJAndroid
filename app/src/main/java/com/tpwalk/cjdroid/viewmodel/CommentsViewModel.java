package com.tpwalk.cjdroid.viewmodel;

import android.app.Activity;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tpwalk.cjdroid.BR;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.adapters.CommentsAdapter;
import com.tpwalk.cjdroid.base.BaseViewModel;
import com.tpwalk.cjdroid.databinding.ActivityCommentsBinding;
import com.tpwalk.dllibrary.impl.CommentServicesImpl;
import com.tpwalk.dllibrary.impl.InvokeApiCallbackData;
import com.tpwalk.dllibrary.model.CommentsModel;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.BindingListViewAdapter;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.collections.MergeObservableList;
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass;

/**
 * 评论逻辑
 * Created by Administrator on 2017/6/23.
 */

public class CommentsViewModel extends BaseViewModel implements
    InvokeApiCallbackData<CommentsModel> {

  private ActivityCommentsBinding activityCommentsBinding;
  private CommentsAdapter commentsAdapter;
  private List<CommentsModel.CommentsBean> commentsBeanList;

  public CommentsViewModel(ActivityCommentsBinding activityCommentsBinding, Activity activity) {

    this.activityCommentsBinding = activityCommentsBinding;
    this.mActivity = activity;

    initAll();
  }

  public final ObservableList<CommentsItemViewModel> items = new ObservableArrayList<>();

  /**
   * Custom adapter that logs calls.
   */
  public final CommentsAdapter<Object> adapter = new CommentsAdapter<>();

  public final MergeObservableList<Object> headerFooterItems = new MergeObservableList<>()
      .insertList(items);
  /**
   * Binds a homogeneous list of items to a layout.
   */
  public final ItemBinding<CommentsItemViewModel> singleItem = ItemBinding
      .of(BR.itemViewModel, R.layout.list_item_comments);

  public final OnItemBindClass<Object> multipleItems = new OnItemBindClass<>()
      .map(CommentsItemViewModel.class, BR.itemViewModel, R.layout.list_item_comments);

  /**
   * Define stable item ids. These are just based on position because the items happen to not
   * every move around.
   */
  public final BindingListViewAdapter.ItemIds<Object> itemIds = new BindingListViewAdapter.ItemIds<Object>() {
    @Override
    public long getItemId(int position, Object item) {
      return position;
    }
  };

  /**
   * Define page titles for a ViewPager
   */
  public final BindingViewPagerAdapter.PageTitles<CommentsItemViewModel> pageTitles = new BindingViewPagerAdapter.PageTitles<CommentsItemViewModel>() {
    @Override
    public CharSequence getPageTitle(int position, CommentsItemViewModel item) {
      return "Item ";
    }
  };

  /**
   * Custom view holders for RecyclerView
   */
  public final BindingRecyclerViewAdapter.ViewHolderFactory viewHolder = new BindingRecyclerViewAdapter.ViewHolderFactory() {
    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewDataBinding binding) {
      return new MyAwesomeViewHolder(binding.getRoot());
    }
  };

  private static class MyAwesomeViewHolder extends RecyclerView.ViewHolder {

    public MyAwesomeViewHolder(View itemView) {
      super(itemView);
    }
  }


  @Override
  protected void initData() {
    CommentServicesImpl.getInstance(mActivity, this).getCommentsAll(mActivity);
  }

  @Override
  protected void initView() {

  }

  @Override
  protected void initListener() {

  }

  @Override
  public void callBackData(CommentsModel commentsModel) {
    if (commentsModel != null) {
      commentsBeanList = commentsModel.getComments();
      for (int i = 0, size = commentsBeanList.size(); i < size; i++) {
        items.add(new CommentsItemViewModel(mActivity, commentsBeanList.get(i)));
      }
    }
  }
}

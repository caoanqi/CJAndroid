package com.tpwalk.cjdroid.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tpwalk.cjdroid.BR;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.databinding.ListItemCommentsBinding;
import com.tpwalk.dllibrary.model.CommentsModel;

import java.util.List;

/**
 * 评论适配器
 * Created by Administrator on 2017/6/23.
 */

public class CommentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CommentsModel.CommentsBean> commentsBeans;
    private Context context;

    public CommentsAdapter(List<CommentsModel.CommentsBean> commentsBeanList, Context context) {
        commentsBeans = commentsBeanList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemCommentsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_comments, parent, false);
        return new CommentsViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CommentsViewHolder commentsViewHolder = (CommentsViewHolder) holder;
        commentsViewHolder.getViewDataBinding().setVariable(BR.commentsModel, commentsBeans.get(position));
        Picasso.with(context).load(commentsBeans.get(position).getAvatar()).into(commentsViewHolder.getViewDataBinding().ivImage);
        commentsViewHolder.getViewDataBinding().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return commentsBeans == null ? 0 : commentsBeans.size();
    }


    class CommentsViewHolder extends RecyclerView.ViewHolder {

        private ListItemCommentsBinding viewDataBinding;

        public CommentsViewHolder(View itemView) {
            super(itemView);
        }

        public CommentsViewHolder(View itemView, ListItemCommentsBinding viewDataBinding) {
            super(itemView);
            this.viewDataBinding = viewDataBinding;

        }

        public ListItemCommentsBinding getViewDataBinding() {
            return viewDataBinding;
        }

        public void setViewDataBinding(ListItemCommentsBinding viewDataBinding) {
            this.viewDataBinding = viewDataBinding;
        }
    }
}

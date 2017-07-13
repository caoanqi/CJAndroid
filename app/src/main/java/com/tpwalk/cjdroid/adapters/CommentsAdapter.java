package com.tpwalk.cjdroid.adapters;

import static android.content.ContentValues.TAG;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * 评论适配器
 * Created by Administrator on 2017/6/23.
 */

public class CommentsAdapter<T> extends BindingRecyclerViewAdapter<T> {

    @Override
    public ViewDataBinding onCreateBinding(LayoutInflater inflater, @LayoutRes int layoutId,
        ViewGroup viewGroup) {
        ViewDataBinding binding = super.onCreateBinding(inflater, layoutId, viewGroup);
        Log.d(TAG, "created binding: " + binding);
        return binding;
    }


    @Override
    public void onBindBinding(ViewDataBinding binding, int variableId, @LayoutRes int layoutRes, int position, T item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        Log.d(TAG, "bound binding: " + binding + " at position: " + position);
    }

}

package com.tpwalk.dllibrary.impl;

import android.content.Context;
import android.widget.Toast;

import com.tpwalk.dllibrary.model.CommentsModel;
import com.tpwalk.dllibrary.services.CommentsServices;
import com.tpwalk.mylibrary.net.RetrofitProvider;
import com.tpwalk.mylibrary.utils.LogUtils;
import com.tpwalk.mylibrary.utils.ToastUtils;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;


/**
 * 评论api 服务接口实现
 * Created by Administrator on 2017/6/23.
 */

public class CommentServicesImpl {

    private static CommentServicesImpl commentServices;
    private InvokeApiCallbackData invokeApiCallbackData;

    private CommentServicesImpl(Context context, InvokeApiCallbackData invokeApiCallbackData) {
        this.invokeApiCallbackData = invokeApiCallbackData;
    }

    public synchronized static CommentServicesImpl getInstance(Context context, InvokeApiCallbackData callbackData) {
        if (commentServices == null) {
            commentServices = new CommentServicesImpl(context, callbackData);
        }
        return commentServices;
    }

    public void getCommentsAll(Context context) {

        CommentsServices services = RetrofitProvider.getInstance().create(CommentsServices.class);
        Call<CommentsModel> result = services.getCommentsAll();
        result.enqueue(new Callback<CommentsModel>() {
            @Override
            public void onResponse(Call<CommentsModel> call, Response<CommentsModel> response) {
                if (invokeApiCallbackData != null) {
                    invokeApiCallbackData.callBackData(response.body());
                }
            }

            @Override
            public void onFailure(Call<CommentsModel> call, Throwable t) {
                LogUtils.e("MYZHIHU", t.getMessage());
                ToastUtils.showLongToast(context, t.getMessage());
            }
        });

    }
}

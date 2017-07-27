package com.tpwalk.dllibrary.impl;

import android.content.Context;
import com.tpwalk.cjdroid.utils.ToastUtils;
import com.tpwalk.dllibrary.model.CommentsModel;
import com.tpwalk.dllibrary.services.CommentsServices;
import com.tpwalk.mylibrary.net.RetrofitProvider;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


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
        Observable<CommentsModel> result = services.getCommentsAll();
        result.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> ToastUtils.showLongToast(context, throwable.getMessage()))
                .subscribe(commentsModel -> {
                    if (invokeApiCallbackData != null) {
                        invokeApiCallbackData.callBackData(commentsModel);
                    }
                });

    }
}

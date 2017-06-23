package com.tpwalk.dllibrary.impl;

import android.content.Context;

import com.tpwalk.dllibrary.model.CommentsModel;
import com.tpwalk.dllibrary.services.CommentsServices;
import com.tpwalk.mylibrary.net.RetrofitProvider;
import com.tpwalk.mylibrary.utils.ToastUtils;

import java.util.List;
import java.util.function.Consumer;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 评论api 服务接口实现
 * Created by Administrator on 2017/6/23.
 */

public class CommentServicesImpl {

    private static CommentsModel commentsModel;

    public static synchronized CommentsModel getCommentsAll(Context context) {

        Observable<Notification<CommentsModel>> commentsOb = RetrofitProvider.getInstance().create(CommentsServices.class)
                .getCommentsAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .materialize().share();
        commentsOb.filter(Notification::isOnError)
                .doOnError(throwable -> {
                    ToastUtils.showLongToast(context, throwable.getMessage());
                });
        commentsOb.filter(Notification::isOnNext).map(Notification::getValue)
                .doOnNext(m -> commentsModel = m);

        return commentsModel;



    }
}

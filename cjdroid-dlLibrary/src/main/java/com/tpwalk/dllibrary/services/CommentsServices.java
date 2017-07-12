package com.tpwalk.dllibrary.services;

import com.tpwalk.dllibrary.model.CommentsModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 知乎评论
 * <p>
 * Created by Administrator on 2017/6/23.
 */

public interface CommentsServices {

    @GET("4/story/4232852/short-comments")
    Observable<CommentsModel> getCommentsAll();
}

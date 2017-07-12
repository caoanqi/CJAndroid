package com.tpwalk.mylibrary.update.networks;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 筑牛更新服务
 * <p>
 * Created by jerry on 16/1/4.
 */
public interface UpdateService {

  String ENDPOINT = ApiUrlUtils.testUrl;

  // 获取本信息

  @POST("version/searchAndroid.do")
  Observable<UpdateInfo> getUpdateInfo(@Body UpdateBody versionCode);

}

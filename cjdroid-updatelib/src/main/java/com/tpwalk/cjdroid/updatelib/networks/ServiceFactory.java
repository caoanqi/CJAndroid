package com.tpwalk.cjdroid.updatelib.networks;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建Retrofit服务
 * <p>
 * Created by wangchenlong on 16/1/4.
 */
public class ServiceFactory {

  public static <T> T createServiceFrom(final Class<T> serviceClass, String endpoint) {

    Retrofit adapter = new Retrofit.Builder()
        .baseUrl(endpoint)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 添加Rx适配器
        .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
        .client(OkHttpManagers.genericClient())
        .build();
    return adapter.create(serviceClass);
  }
}

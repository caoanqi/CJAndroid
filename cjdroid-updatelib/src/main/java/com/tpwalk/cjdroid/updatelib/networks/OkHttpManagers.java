package com.tpwalk.cjdroid.updatelib.networks;


import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by jerry on 2016/10/9.
 */

public class OkHttpManagers {

  public static OkHttpClient genericClient() {
    OkHttpClient httpClient = new OkHttpClient();

    httpClient.interceptors().add(chain -> {
      Request request = chain.request()
          .newBuilder()
          .addHeader("Content-Type", "application/json")
          .addHeader("Accept", "application/json")
          .build();
      return chain.proceed(request);
    });

    return httpClient;
  }
}

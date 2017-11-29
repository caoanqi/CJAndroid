package com.tpwalk.cjdroid.updatelib.networks;


import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jerry on 2016/10/9.
 */

public class RequestInterceptor implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();
    Request request = original.newBuilder()
        .header("Accept", "application/json")
        .header("Content-Type", "application/json")
        .method(original.method(), original.body())
        .build();
    return chain.proceed(request);
  }

}
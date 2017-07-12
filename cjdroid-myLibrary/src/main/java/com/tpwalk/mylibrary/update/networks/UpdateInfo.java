package com.tpwalk.mylibrary.update.networks;

/**
 * 更新信息(JSON)
 * <p>
 * Created by wangchenlong on 16/1/4.
 */
public class UpdateInfo {

  public Data result; // 信息
  public boolean success; // 访问是否成功
  public String message; // 错误信息

  public static class Data {

    public String versionCode; // 当前版本（如1.0.1）
    public String appURL; // 下载地址
    public String description; // 描述
    public String versionName;//版本名称（如1.0.0）
    public boolean forceupdate;//是否强制更新

  }

  @Override
  public String toString() {
    return "当前版本: " + result.versionCode + ", 下载地址: " + result.appURL + ", 描述信息: "
        + result.description
        + "版本名称" + result.versionName + ", 错误信息: " + message;
  }
}

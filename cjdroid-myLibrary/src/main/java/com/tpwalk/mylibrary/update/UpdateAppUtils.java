package com.tpwalk.mylibrary.update;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import com.tpwalk.mylibrary.update.networks.ServiceFactory;
import com.tpwalk.mylibrary.update.networks.UpdateBody;
import com.tpwalk.mylibrary.update.networks.UpdateInfo;
import com.tpwalk.mylibrary.update.networks.UpdateService;
import com.tpwalk.mylibrary.update.utils.PrefsConsts;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * 更新管理器
 * <p>
 * Created by jerry on 16/1/6.
 */
@SuppressWarnings("unused")
public class UpdateAppUtils {

  @SuppressWarnings("unused")
  private static final String TAG = "DEBUG-WCL: " + UpdateAppUtils.class.getSimpleName();

  /**
   * 检查更新
   */
  @SuppressWarnings("unused")
  public static void checkUpdate(String curVersion, UpdateCallback updateCallback) {
    UpdateBody updateBody = new UpdateBody(curVersion);
    UpdateService updateService = ServiceFactory
        .createServiceFrom(UpdateService.class, UpdateService.ENDPOINT);

    updateService.getUpdateInfo(updateBody)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(updateInfo -> onNext(updateInfo, updateCallback),
            throwable -> onError(throwable, updateCallback));
  }

  // 显示信息
  private static void onNext(UpdateInfo updateInfo, UpdateCallback updateCallback) {
    Log.e(TAG, "返回数据: " + updateInfo.toString());
    if (updateInfo.success == false || updateInfo.result == null ||
        updateInfo.result.appURL == null) {
      updateCallback.onError(updateInfo.message); // 失败
    } else {
      updateCallback.onSuccess(updateInfo);
    }
  }

  // 错误信息
  private static void onError(Throwable throwable, UpdateCallback updateCallback) {
    updateCallback.onError(throwable.getMessage());
  }

  /**
   * 下载Apk, 并设置Apk地址,
   * 默认位置: /storage/sdcard0/Download
   *
   * @param context 上下文
   * @param updateInfo 更新信息
   * @param infoName 通知名称
   * @param storeApk 存储的Apk
   */
  @SuppressWarnings("unused")
  public static void downloadApk(Context context, UpdateInfo updateInfo, String infoName,
      String storeApk) {
    if (!isDownloadManagerAvailable()) {
      return;
    }

    String description = updateInfo.result.description;
    String appUrl = updateInfo.result.appURL;

    if (appUrl == null || appUrl.isEmpty()) {
      Log.e(TAG, "请填写\"App下载地址\"");
      return;
    }

    appUrl = appUrl.trim(); // 去掉首尾空格

    if (!appUrl.startsWith("http")) {
      appUrl = "http://" + appUrl; // 添加Http信息
    }

    Log.e(TAG, "appUrl: " + appUrl);

    DownloadManager.Request request;
    try {
      request = new DownloadManager.Request(Uri.parse(appUrl));
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
    request.setTitle(infoName);
    request.setDescription(description);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
      request.allowScanningByMediaScanner();
      request
          .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
    }
    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, storeApk);

    Context appContext = context.getApplicationContext();
    DownloadManager manager = (DownloadManager) appContext.getSystemService(Context.DOWNLOAD_SERVICE);

    // 存储下载Key
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(appContext);
    sp.edit().putLong(PrefsConsts.DOWNLOAD_APK_ID_PREFS, manager.enqueue(request)).apply();
  }

  // 最小版本号大于9
  private static boolean isDownloadManagerAvailable() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
  }

  // 错误回调
  public interface UpdateCallback {

    void onSuccess(UpdateInfo updateInfo);

    void onError(String errMsg);
  }
}

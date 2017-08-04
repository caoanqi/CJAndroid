package com.tpwalk.cjdroid.citypicker.utils;

/**
 * 字符串处理
 */
public class StringUtils {

  /**
   * 提取出城市或者县
   */
  public static String extractLocation(final String city, final String district) {
    return district.contains("县") ? district.substring(0, district.length() - 1)
        : city.substring(0, city.length() - 1);
  }
}

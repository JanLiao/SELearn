/*
 * Copyright (c) 2020
 * User:jan
 * File:CharacterUtil.java
 * Date:2020/11/29 19:26:29
 */

package football.util;

import java.io.UnsupportedEncodingException;

/**
 * author: janliao
 * createTime: 2020/11/29 19:26
 * version: 1.0
 */
public class CharacterUtil {

  private static String changeCharSet(
      String str, String newCharset) throws UnsupportedEncodingException {
    if (str != null) {
      // 用默认字符编码解码字符串。
      byte[] bs = str.getBytes();
      // 用新的字符编码生成字符串
      return new String(bs, newCharset);
    }
    return str;
  }

  /**
   * 字符串转化为UTF-8
   * @param str
   * @return
   */
  public static String toUTF8(String str){
    String result = str;
    try {
      result = changeCharSet(str, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return result;
  }
}

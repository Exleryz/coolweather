package com.yezhou.example.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/12/14.
 */

public class HttpUtil {

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {    // 与服务器交互代码 注册回调处理服务器响应
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();    // 传入请求地址
        client.newCall(request).enqueue(callback);
    }

}

package com.astound.zechat.utils;

import android.app.ProgressDialog;

import com.astound.zechat.zechatwebservices.ZeChatRetrofitClient;
import com.astound.zechat.zechatwebservices.ZeChatRetrofitInterface;

import retrofit2.Retrofit;

/**
 * Created by Android on 2/10/2017.
 */

public class Constant
{
    private static Retrofit zeChatRetrofitClient = ZeChatRetrofitClient.getClient();
    public static ZeChatRetrofitInterface zeChatRetrofitInterface = zeChatRetrofitClient.create(ZeChatRetrofitInterface.class);
    public static ProgressDialog progressDialog;
}

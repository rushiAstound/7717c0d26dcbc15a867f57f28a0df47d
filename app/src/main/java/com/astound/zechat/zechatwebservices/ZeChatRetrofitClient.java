package com.astound.zechat.zechatwebservices;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android on 10/11/2016.
 */

public class ZeChatRetrofitClient
{
    public static final String BASE_URL = "http://astounddev.com";
    private static Retrofit adapter = null;

    static OkHttpClient okClient = new OkHttpClient.Builder()
            .authenticator(new Authenticator()
            {
                @Override
                public Request authenticate(Route route, Response response) throws IOException
                {
                    String credential = Credentials.basic("admin", "1234");
                    return response.request().newBuilder()
                            .header("Authorization", credential)
                            .build();
                }
            })
            .addNetworkInterceptor(new StethoInterceptor())
            .build();

    public static Retrofit getClient()
    {
        if (adapter == null)
        {
            adapter = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okClient)
                    .build();
        }
        return adapter;
    }
}

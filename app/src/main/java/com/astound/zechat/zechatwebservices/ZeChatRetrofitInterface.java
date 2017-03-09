package com.astound.zechat.zechatwebservices;

import com.astound.zechat.zechatwebservices.login_and_register.ZeChatLoginAndRegister;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Android on 10/11/2016.
 */

public interface ZeChatRetrofitInterface
{
//////////////////////////////////LOGIN WEBSERVICE//////////////////////////////////////////////////
    @POST("/zeechatapi/zechat/login")
    Call<ZeChatLoginAndRegister> login(@Query("u_username") String u_username,
                                       @Query("u_password") String u_password);
////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////REGISTER WEBSERVICE///////////////////////////////////////////
    @POST("/zeechatapi/zechat/register")
    Call<ZeChatLoginAndRegister> register(@Query("u_username") String u_username,
                                          @Query("u_password") String u_password,
                                          @Query("u_email") String u_email,
                                          @Query("u_phone") String u_phone);
////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////FORGOT PASS WEBSERVICE////////////////////////////////////////
    @POST("/zeechatapi/zechat/forgotpass")
    Call<ZeChatLoginAndRegister> forgotpass(@Query("u_email") String u_email,
                                            @Query("u_phone") String u_phone);
////////////////////////////////////////////////////////////////////////////////////////////////////

}
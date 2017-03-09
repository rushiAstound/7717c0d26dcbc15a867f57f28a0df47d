
package com.astound.zechat.zechatwebservices.login_and_register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZeChatLoginAndRegister
{
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData()
    {
        return data;
    }

    public void setData(Data data)
    {
        this.data = data;
    }

}

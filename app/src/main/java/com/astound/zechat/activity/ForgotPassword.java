package com.astound.zechat.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.astound.zechat.R;
import com.astound.zechat.utils.Utilities;
import com.astound.zechat.zechatwebservices.login_and_register.ZeChatLoginAndRegister;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.astound.zechat.utils.Constant.zeChatRetrofitInterface;

public class ForgotPassword extends AppCompatActivity implements Callback
{
    @BindView(R.id.etForgotPassDetails)  EditText etForgotPassDetails;
    @BindView(R.id.btnForgotPassSubmit)  EditText btnForgotPassSubmit;
    private Call forgotPassCall;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    @SuppressWarnings("unchecked")
    @OnClick(R.id.btnForgotPassSubmit)
    void submit()
    {
        /* Not Implemented yet on server side. Work under Progress*/
        forgotPassCall= zeChatRetrofitInterface.forgotpass("","");
        forgotPassCall.enqueue(this);
    }
    @Override
    public void onResponse(Call call, Response response)
    {
        if(call.equals(forgotPassCall))
        {
            if(response.code()==200)
            {
                ZeChatLoginAndRegister zeChatLoginAndRegister = (ZeChatLoginAndRegister) response.body();
                Boolean success = zeChatLoginAndRegister.getData().getStatus();
                if (success.equals(true))
                {
                    Utilities.showToast(getResources().getString(R.string.toast_success_forgot_pass), ForgotPassword.this);
                } else if (success.equals(false))
                {
                    Utilities.showToast(getResources().getString(R.string.toast_failure_forgot_pass), ForgotPassword.this);
                }
            }else
            {
                if(response.code()==404)
                {
                    Utilities.showToast(getResources().getString(R.string.toast_failure_forgot_pass), ForgotPassword.this);
                }
            }
        }

    }

    @Override
    public void onFailure(Call call, Throwable t)
    {
        Utilities.showToast(getResources().getString(R.string.toast_failure_network_login),ForgotPassword.this);
    }

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

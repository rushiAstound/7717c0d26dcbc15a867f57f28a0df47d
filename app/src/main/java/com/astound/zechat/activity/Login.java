package com.astound.zechat.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.astound.zechat.R;
import com.astound.zechat.zechatwebservices.login_and_register.ZeChatLoginAndRegister;
import com.astound.zechat.utils.Utilities;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.astound.zechat.utils.Constant.zeChatRetrofitInterface;
import static com.astound.zechat.utils.Constant.progressDialog;

public class Login extends AppCompatActivity implements Callback
{
    @BindView(R.id.etLoginUserName) EditText etLoginUserName;
    @BindView(R.id.etLoginPassword) EditText etLoginPassword;
    @BindView(R.id.txtLoginForgotPass) TextView txtLoginForgotPass;
    @BindView(R.id.btnLoginSignIn)  Button btnLoginSignIn;
    @BindView(R.id.btnLoginSignUp) Button btnLoginSignUp;
    private Call loginCall;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLoginSignUp)
    void signUp()
    {
        startActivity(new Intent(Login.this,SignUp.class));
    }

    @SuppressWarnings("unchecked")
    @OnClick(R.id.btnLoginSignIn)
    void signIn()
    {
        progressDialog= ProgressDialog.show(Login.this,"",getResources().getString(R.string.txt_progressdialog));
        String u_username,u_password;
        u_username=etLoginUserName.getText().toString();
        u_password=etLoginPassword.getText().toString();

        loginCall= zeChatRetrofitInterface.login(u_username,u_password);
        loginCall.enqueue(this);
    }

    @OnClick(R.id.txtLoginForgotPass)
    void loginForgotPass()
    {
        startActivity(new Intent(Login.this,ForgotPassword.class));
    }

    @Override
    public void onResponse(Call call, Response response)
    {
        progressDialog.dismiss();
        if(call.equals(loginCall))
        {
            if(response.code()==200)
            {
                ZeChatLoginAndRegister zeChatLoginAndRegister = (ZeChatLoginAndRegister) response.body();
                Boolean success = zeChatLoginAndRegister.getData().getStatus();
                if (success.equals(true))
                {
                    Utilities.showToast(getResources().getString(R.string.toast_success_login), Login.this);
                    startActivity(new Intent(Login.this,MainContainerActivity.class));
                } else if (success.equals(false))
                {
                    Utilities.showToast(getResources().getString(R.string.toast_failure_login), Login.this);
                }
            }else
            {
                if(response.code()==404)
                {
                    Utilities.showToast(getResources().getString(R.string.toast_failure_login), Login.this);
                }
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t)
    {
        Utilities.showToast(getResources().getString(R.string.toast_failure_network_login),Login.this);
    }

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

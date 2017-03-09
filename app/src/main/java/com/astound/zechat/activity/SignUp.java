package com.astound.zechat.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
import static com.astound.zechat.utils.Utilities.eMailValidation;
import static com.astound.zechat.utils.Utilities.showToast;

public class SignUp extends AppCompatActivity implements Callback
{
    @BindView(R.id.etSignUpEmail) EditText etSignUpEmail;
    @BindView(R.id.etSignUpPassword) EditText etSignUpPassword;
    @BindView(R.id.etSignUpUserName) EditText etSignUpUserName;
    @BindView(R.id.etSignUpPhone) EditText etSignUpPhone;
    @BindView(R.id.btnGetStarted) Button btnGetStarted;
    private Call signUpCall;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @SuppressWarnings("unchecked")
    @OnClick(R.id.btnGetStarted)
    void getStarted()
    {
        String u_username,u_password,u_email,u_phone;

        u_username=etSignUpUserName.getText().toString();
        u_password=etSignUpPassword.getText().toString();
        u_email=etSignUpEmail.getText().toString();
        u_phone=etSignUpPhone.getText().toString();

        if(!eMailValidation(u_email))
        {
            showToast(getResources().getString(R.string.toast_email_empty_sign_up),SignUp.this);
        }else
        {
            progressDialog = ProgressDialog.show(SignUp.this, "", getResources().getString(R.string.txt_progressdialog));
            signUpCall = zeChatRetrofitInterface.register(u_username, u_password, u_email, u_phone);
            signUpCall.enqueue(this);
        }
    }

    @Override
    public void onResponse(Call call, Response response)
    {
        progressDialog.dismiss();
        if(call.equals(signUpCall))
        {
            if(response.code()==200)
            {
                ZeChatLoginAndRegister zeChatLoginAndRegister = (ZeChatLoginAndRegister) response.body();
                Boolean success = zeChatLoginAndRegister.getData().getStatus();
                if (success.equals(true))
                {
                    showToast(getResources().getString(R.string.toast_success_sign_up), SignUp.this);
                } else if (success.equals(false))
                {
                    showToast(zeChatLoginAndRegister.getData().getMessage(), SignUp.this);
                }
            }else
            {
                if(response.code()==404)
                {
                    showToast(getResources().getString(R.string.toast_failure_sign_up), SignUp.this);
                }
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t)
    {
    }

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

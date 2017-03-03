package com.example.a27459.juejin.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a27459.juejin.R;
import com.example.a27459.juejin.base.BaseActivity;
import com.example.a27459.juejin.model.Account;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends BaseActivity {

    @BindView(R.id.editext_signIn_account)
    EditText mEditText_account;
    @BindView(R.id.editext_signIn_pwd)
    EditText mEditText_pwd;
    @BindView(R.id.editext_signIn_mail)
    EditText mEditText_mail;
    @BindView(R.id.button_commit_signIn)
    Button mButton_commit;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {
        mButton_commit.setOnClickListener(new View.OnClickListener() {
            private String mail;
            private String pwd;
            private String act;

            @Override
            public void onClick(View view) {
                act = mEditText_account.getText().toString();
                pwd = mEditText_pwd.getText().toString();
                mail = mEditText_mail.getText().toString();
                Account account = new Account();
                account.setAccount(act);
                account.setEmail(mail);
                account.setPwd(pwd);


                OkHttpClient okHttpClient = new OkHttpClient();
                FormEncodingBuilder builder = new FormEncodingBuilder();
                builder.add("userName",act);
                builder.add("pwd",pwd);
                Request request = new Request.Builder()
                        .url("")
                        .post(builder.build())
                        .build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {

                    }
                });











            }
        });

    }
}

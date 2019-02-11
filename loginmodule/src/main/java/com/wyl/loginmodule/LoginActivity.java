package com.wyl.loginmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wyl.basemodule.utils.ToastUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean hasClicked;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginmodule_activity_login);


        info = getIntent().getStringExtra("info");
    }

    @Override
    public void onClick(View v) {
        if (hasClicked) {
            // 点击登录
            ToastUtils.showShortToast("登录成功");
        } else {
            ToastUtils.showShortToast(info);
            hasClicked = true;
        }
    }
}

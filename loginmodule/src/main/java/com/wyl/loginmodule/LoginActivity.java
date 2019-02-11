package com.wyl.loginmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mzule.activityrouter.annotation.Router;
import com.wyl.basemodule.utils.ToastUtils;
import com.wyl.loginmodule.eventbus.LoginEvent;

import org.greenrobot.eventbus.EventBus;

@Router("login/:info")
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
            setResult(RESULT_OK, new Intent().putExtra("info", "登录成功"));
            EventBus.getDefault().post(new LoginEvent());
            finish();
        } else {
            ToastUtils.showShortToast(info);
            hasClicked = true;
        }
    }
}

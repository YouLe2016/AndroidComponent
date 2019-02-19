package com.wyl.minemodule;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.github.mzule.activityrouter.router.Routers;
import com.wyl.basemodule.base.BaseFragment;
import com.wyl.basemodule.utils.ToastUtils;
import com.wyl.minemodule.databinding.MinemoduleFragmentMineBinding;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment<MinemoduleFragmentMineBinding> implements View.OnClickListener {
    private static final int LOGIN_CODE = 200;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.minemodule_fragment_mine;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        binding.setFragment(this);
    }

    @Override
    public void onClick(View v) {
        // 点击跳转到登录页面
        ToastUtils.showShortToast("点击跳转到登录页面");
//        intent2Login();
        activityRouter2Login();
    }

    private void activityRouter2Login() {
        Routers.open(getActivity(), "loginmodule://login/123");
//        Routers.openForResult(getActivity(), "loginmodule://login/123", LOGIN_CODE);
    }

    private void intent2Login() {
        try {
            Class login = Class.forName("com.wyl.loginmodule.LoginActivity");
            Bundle bundle = new Bundle();
            bundle.putString("info", "123");
            startActivity(login, bundle);
            startActivityForResult(login, bundle, LOGIN_CODE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            ToastUtils.showShortToast(e.getMessage());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || requestCode != LOGIN_CODE) {
            return;
        }
        String info = data.getStringExtra("info");
        ToastUtils.showShortToast(info);
    }
}

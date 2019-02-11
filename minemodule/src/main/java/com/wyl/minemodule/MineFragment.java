package com.wyl.minemodule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.wyl.basemodule.BaseFragment;
import com.wyl.basemodule.utils.ToastUtils;
import com.wyl.minemodule.databinding.MinemoduleFragmentMineBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment<MinemoduleFragmentMineBinding> implements View.OnClickListener {


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
    }
}

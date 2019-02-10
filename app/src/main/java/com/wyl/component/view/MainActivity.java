package com.wyl.component.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.wyl.basemodule.BaseActivity;
import com.wyl.component.R;
import com.wyl.component.databinding.ActivityMainBinding;
import com.wyl.component.view.fragment.HomeFragment;
import com.wyl.component.view.fragment.MineFragment;
import com.wyl.component.view.fragment.OtherFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    FragmentManager fragmentManager;
    Fragment[] fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        init();
    }

    private void init() {
        fragmentManager = getSupportFragmentManager();
        fragments = new Fragment[]{
                new HomeFragment(), new MineFragment(), new OtherFragment()
        };

        fragmentManager.beginTransaction().show(fragments[0]).commit();
    }

    void hideAllFragment(FragmentTransaction transaction) {
        for (Fragment fragment : fragments) {
            transaction.hide(fragment);
        }
    }

    void showFragment(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideAllFragment(transaction);
        if (fragments[i].isAdded()) {
            transaction.show(fragments[i]);
        } else {
            transaction.add(R.id.frameLayout, fragments[i], String.valueOf(i));
        }
        transaction.commit();
    }

    public void onClickBtHome(View view) {
        showFragment(0);
    }

    public void onClickBtMine(View view) {
        showFragment(1);
    }

    public void onClickBtOther(View view) {
        showFragment(2);
    }
}

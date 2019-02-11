package com.wyl.component.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.wyl.basemodule.BaseActivity;
import com.wyl.component.R;
import com.wyl.component.databinding.ActivityMainBinding;
import com.wyl.component.view.fragment.MineFragment;
import com.wyl.component.view.fragment.OtherFragment;
import com.wyl.homemodule.HomeFragment;

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

        for (int i = 0; i < fragments.length; i++) {
            Fragment fragment = fragmentManager.findFragmentByTag(String.valueOf(i));
            if (fragment != null) {
                fragmentManager.beginTransaction().remove(fragment).commit();
            }
        }

        fragmentManager.beginTransaction().add(R.id.frameLayout, fragments[0], String.valueOf(0)).commit();
    }

    void hideAllFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (Fragment fragment : fragments) {
            transaction.hide(fragment);
        }
        transaction.commit();
    }

    void showFragment(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragments[i].isAdded()) {
            transaction.show(fragments[i]);
        } else {
            transaction.add(R.id.frameLayout, fragments[i], String.valueOf(i)).show(fragments[i]);
        }
        transaction.commit();
    }

    public void onClickBtHome(View view) {
        hideAllFragment();
        showFragment(0);
    }

    public void onClickBtMine(View view) {
        hideAllFragment();
        showFragment(1);
    }

    public void onClickBtOther(View view) {
        hideAllFragment();
        showFragment(2);
    }
}

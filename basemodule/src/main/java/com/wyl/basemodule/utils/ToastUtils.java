package com.wyl.basemodule.utils;


import android.widget.Toast;

import com.wyl.basemodule.BaseApplication;


public class ToastUtils {
    private static Toast toast;

    /**
     * 强大的吐司，能够连续弹的吐司
     *
     * @param text
     */
    public static void showLongToast(String text) {
        if (toast == null) {
            //如果等于null，则创建
            toast = Toast.makeText(BaseApplication.getContext(), text, Toast.LENGTH_LONG);
        } else {
            //如果不等于空，则直接将text设置给toast
            toast.setText(text);
        }
        toast.show();
    }

    public static void showShortToast(String text) {
        if (toast == null) {
            //如果等于null，则创建
            toast = Toast.makeText(BaseApplication.getContext(), text, Toast.LENGTH_SHORT);
        } else {
            //如果不等于空，则直接将text设置给toast
            toast.setText(text);
        }
        toast.show();
    }
}

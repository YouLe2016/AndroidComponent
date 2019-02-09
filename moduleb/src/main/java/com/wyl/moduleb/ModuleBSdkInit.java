package com.wyl.moduleb;

import android.util.Log;


/**
 * 时间：2019/2/9 14:55
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class ModuleBSdkInit {
    private static final String TAG = "ModuleBSdkInit";

    private ModuleBSdkInit() {
    }

    public static ModuleBSdkInit getInstance() {
        return Holder.INSTANCE;

    }

    private static class Holder {
        private static ModuleBSdkInit INSTANCE = new ModuleBSdkInit();
    }

    public void init() {
        Log.d(TAG, "init: moduleb" );
    }
}

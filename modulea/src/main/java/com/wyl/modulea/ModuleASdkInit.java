package com.wyl.modulea;

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
public class ModuleASdkInit {
    private static final String TAG = "ModuleASdkInit";

    private ModuleASdkInit() {
    }

    public static ModuleASdkInit getInstance() {
        return Holder.INSTANCE;

    }

    private static class Holder {
        private static ModuleASdkInit INSTANCE = new ModuleASdkInit();
    }

    public void init() {
        Log.d(TAG, "init: modulea" );
    }
}

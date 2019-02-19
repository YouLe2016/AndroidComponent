package com.wyl.component;

import com.wyl.basemodule.base.BaseApplication;


/**
 * 时间：2019/2/9 15:10
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleASdkInit.getInstance().init();
        ModuleBSdkInit.getInstance().init();
    }
}

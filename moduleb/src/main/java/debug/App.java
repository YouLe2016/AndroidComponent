package debug;

import android.app.Application;

import com.wyl.moduleb.ModuleBSdkInit;

/**
 * 时间：2019/2/9 15:03
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleBSdkInit.getInstance().init();
    }
}

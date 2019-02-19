package com.wyl.basemodule.permisions;

import android.app.Activity;

import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.wyl.basemodule.utils.ToastUtils;

import java.util.List;

/**
 * 时间：2018/12/19 15:52
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class PermissionsUtil {
    public static void checkPermissionsDo(Activity context, Runnable runnable, String... permissions) {
        if (XXPermissions.isHasPermission(context, permissions)) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        XXPermissions.with(context)
//                .constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
                .permission(permissions) //不指定权限则自动获取清单中的危险权限
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {
                        if (isAll) {
                            //权限获取成功
                            if (runnable != null) {
                                runnable.run();
                            }
                        } else {
                            //获取权限成功，部分权限未正常授予
                            ToastUtils.showShortToast("获取权限成功，部分权限未正常授予");
                        }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        //获取权限失败
                        if (quick) {
                            //如果是被永久拒绝就跳转到应用权限系统设置页面
                            XXPermissions.gotoPermissionSettings(context);
                        } else {
                            //获取权限失败
                            ToastUtils.showShortToast("获取权限失败");
                        }
                    }
                });
    }

}

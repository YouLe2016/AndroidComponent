package com.wyl.homemodule;

import com.wyl.basemodule.adapter.BindingData;

/**
 * 时间：2019/2/10 12:56
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class HomeItemBean implements BindingData {
    private int resourceId;

    public HomeItemBean(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.modulehome_item_home;
    }
}

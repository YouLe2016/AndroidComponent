package com.wyl.homemodule;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

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
public class HomeItemBean extends BaseObservable implements BindingData {
    private int resourceId;
    private String str;

    public HomeItemBean(int resourceId, String str) {
        this.resourceId = resourceId;
        this.str = str;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Bindable
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
        notifyPropertyChanged(BR.str);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.modulehome_item_home;
    }
}

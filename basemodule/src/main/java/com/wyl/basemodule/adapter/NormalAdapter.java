package com.wyl.basemodule.adapter;

import android.databinding.ViewDataBinding;

import java.util.List;

/**
 * 时间：2019/1/30 11:12
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class NormalAdapter<T extends BindingData> extends BindingAdapter<T> {

    public NormalAdapter(List<T> data, int variableId) {
        super(data, variableId);
    }

    @Override
    protected void setItemChildClickListener(ViewDataBinding binding, int index) {

    }

}

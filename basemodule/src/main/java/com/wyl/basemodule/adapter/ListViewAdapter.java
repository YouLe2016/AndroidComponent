package com.wyl.basemodule.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Objects;


/**
 * 时间：2019/1/21 17:24
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class ListViewAdapter extends BaseAdapter {
    List<BindingData> dataList;
    int variableId;

    public ListViewAdapter(List<BindingData> dataList, int variableId) {
        this.dataList = dataList;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getViewLayoutId();
    }

    @Override
    public BindingData getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), dataList.get(position).getViewLayoutId(), parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        Objects.requireNonNull(binding).setVariable(variableId, dataList.get(position));
        binding.executePendingBindings();
        return binding.getRoot();
    }

}

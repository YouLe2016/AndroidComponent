package com.wyl.basemodule.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

//import com.android.databinding.library.baseAdapters.BR;

/**
 * 时间：2018/11/15 16:24
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public abstract class DataBindingAdapter<T extends BindingData> extends RecyclerView.Adapter {

    private static final int HEADER = 1000;
    private static int FOOTER = 2000;

    private ViewDataBinding headerBinding;
    private ViewDataBinding footerBinding;

    public void setHeaderBinding(ViewDataBinding headerBinding) {
        this.headerBinding = headerBinding;
    }

    public void setFooterBinding(ViewDataBinding footerBinding) {
        this.footerBinding = footerBinding;
    }

    protected List<T> dataList;
    int variableId;

    public DataBindingAdapter(List<T> data, int variableId) {
        this.dataList = data;
        this.variableId = variableId;
    }

    private OnItemClickListener onItemClickListener;

    //    public OnItemClickListener onItemChildClickListener;

    public void setNewDataList(List<T> dataList) {
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == HEADER) {
            binding = headerBinding;
//            return new ViewHolder(headerView);
        } else if (viewType == FOOTER) {
            binding = footerBinding;
        } else {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        }
        return new BindingViewHolder<>(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEADER) {
            return;
        }
        if (getItemViewType(position) == FOOTER) {
            return;
        }
        int index = position - getHeadersCount();
        ViewDataBinding binding = ((BindingViewHolder) holder).getBinding();
        binding.setVariable(variableId, dataList.get(index));
        binding.executePendingBindings();//此方法必须执行在UI线程，当绑定的数据修改时更新视图（不知道翻译的准不准）
        if (onItemClickListener != null) {
            binding.getRoot().setOnClickListener(v -> onItemClickListener.onClicked(binding, index));
        }
        setItemChildClickListener(binding, index);
    }

    protected abstract void setItemChildClickListener(ViewDataBinding binding, int position);

    @Override
    public int getItemViewType(int position) {
        if (position < getHeadersCount()) {
            return HEADER;
        }
        if (position >= getHeadersCount() + dataList.size()) {
            return FOOTER;
        }
        return dataList.get(position - getHeadersCount()).getViewLayoutId();        //矫正下标
    }

    @Override
    public int getItemCount() {
        return getHeadersCount() + dataList.size() + getFootersCount();
    }

    public int getHeadersCount() {
        return headerBinding != null ? 1 : 0;
    }

    public int getFootersCount() {
        return footerBinding != null ? 1 : 0;
    }

    public void remove(int position) {
        dataList.remove(position);
        int correctPosition = correctPosition(position);
        notifyItemRemoved(correctPosition);
        int itemCount = dataList.size() - position;
        notifyItemRangeChanged(correctPosition, itemCount);
    }

    public void insert(int position, T data) {
        dataList.add(position, data);
        int correctPosition = correctPosition(position);
        notifyItemInserted(correctPosition);
        notifyItemRangeChanged(correctPosition, dataList.size() - position);
    }

    private int correctPosition(int position) {
        return getHeadersCount() + position;
    }

    public interface OnItemClickListener {
        void onClicked(ViewDataBinding binding, int position);
    }

}
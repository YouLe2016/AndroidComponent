package com.wyl.basemodule;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;


/**
 * 时间：2018/10/27 11:54
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public abstract class VmFragment<T extends ViewDataBinding, VM extends BaseViewModel>  extends BaseFragment<T>{
    protected VM viewModel;
    @Override
    protected void createViewModel() {
        viewModel = ViewModelProviders.of(getActivity()).get(getViewModelClass());
    }

    protected abstract Class<VM> getViewModelClass();

}

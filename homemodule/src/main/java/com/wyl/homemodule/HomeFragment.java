package com.wyl.homemodule;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.wyl.basemodule.banner.GlideImageLoader;
import com.wyl.basemodule.base.BaseFragment;
import com.wyl.basemodule.adapter.NormalAdapter;
import com.wyl.basemodule.utils.ToastUtils;
import com.wyl.homemodule.databinding.ModulehomeFragmentHomeBinding;
import com.wyl.homemodule.databinding.ModulehomeItemHomeHeaderBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<ModulehomeFragmentHomeBinding> {

    private NormalAdapter<HomeItemBean> adapter;

    private List<Integer> images;
//    private HomeAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.modulehome_fragment_home;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        images = getBannerImages();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NormalAdapter<>(getHomeList(), com.wyl.homemodule.BR.data);
        ModulehomeItemHomeHeaderBinding headerBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.modulehome_item_home_header, binding.recyclerView, false);
        headerBinding.banner.setImages(getBannerImages()).setImageLoader(new GlideImageLoader()).start();
        adapter.setHeaderBinding(headerBinding);
        binding.recyclerView.setAdapter(adapter);

        binding.refreshLayout.setEnableLoadmore(false);
        binding.refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showShortToast("刷新完成");
                        refreshLayout.finishRefreshing();
                        adapter.getDataList().get(0).setStr("刷新成功");
                    }
                }, 2000);
            }

//            @Override
//            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        refreshLayout.finishLoadmore();
//                    }
//                }, 2000);
//            }
        });
    }

    private List<Integer> getBannerImages() {
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.ic_launcher);
        data.add(R.drawable.ic_launcher);
        data.add(R.drawable.ic_launcher);
        data.add(R.drawable.ic_launcher);
        data.add(R.drawable.ic_launcher);
        return data;
    }

    private List<HomeItemBean> getHomeList() {
        List<HomeItemBean> data = new ArrayList<>();
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        data.add(new HomeItemBean(R.drawable.ic_launcher, "abc"));
        return data;
    }

    /*private class HomeAdapter extends RecyclerView.Adapter {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            switch (viewType) {
                case 1:
                    Banner banner = (Banner) getLayoutInflater().inflate(R.layout.modulehome_item_home_header, HomeFragment.this.binding.recyclerView, false);
                    return new ViewHolder(banner);
                default:
                    ModulehomeItemHomeBinding binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.modulehome_item_home, HomeFragment.this.binding.recyclerView, false);
                    return new BindingViewHolder<>(binding);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof BindingViewHolder) {
                position -= 1;
                BindingViewHolder<ModulehomeItemHomeBinding> bindingViewHolder = (BindingViewHolder) holder;
                bindingViewHolder.getBinding().imageView.setImageResource(images.get(position));
            }else if (holder instanceof ViewHolder){
                ViewHolder viewHolder = (ViewHolder) holder;
                ((Banner) viewHolder.itemView).setImages(getBannerImages()).setImageLoader(new GlideImageLoader()).start();
            }

        }

        @Override
        public int getItemViewType(int position) {
            return position == 0 ? 1 : 0;
        }

        @Override
        public int getItemCount() {
            return images.size() + 1;
        }

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }*/

}

package com.wyl.basemodule.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lcodecore.tkrefreshlayout.header.progresslayout.CircleImageView;

/**
 * 时间：2019/1/21 13:40
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class ImageLoader {
    @BindingAdapter(value = {"url", "placeholde", "error", "round"}, requireAll = false)
    public static void loadImage(ImageView imageView, String url, Drawable placeholderRes, Drawable errorRes, boolean isRound) {
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderRes)
                .error(errorRes);
        if (isRound) {
            options = options.circleCrop();
        }
        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void loadImage(ImageView imageView, String url, @DrawableRes int placeholderRes, @DrawableRes int errorRes, boolean isRound) {
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderRes)
                .error(errorRes);
        if (isRound) {
            options = options.circleCrop();
        }
        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }

}

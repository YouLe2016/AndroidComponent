package com.wyl.commonmodule.utils;

//import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间：2019/2/3 11:42
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
//public class RetrofitUtils {
//
//    private RetrofitUtils() {
//    }
//
//    public static RetrofitUtils getInstance() {
//        return Holder.INSTANCE;
//
//    }
//
//    private static class Holder {
//        private static RetrofitUtils INSTANCE = new RetrofitUtils();
//    }
//
//    private Retrofit retrofit;
//
//    private OkHttpClient okHttpClient;
//
//    public Retrofit getRetrofit() {
//        return retrofit;
//    }
//
//    public OkHttpClient getOkHttpClient() {
//        return okHttpClient;
//    }
//
//    private void init() {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        //应用程序拦截器
//        okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(logging)//应用程序拦截器
//                .build();
//
//        retrofit = new Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl("http://guolin.tech/")
//                .addConverterFactory(GsonConverterFactory.create()) //添加Gson转换器
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  // 添加Rxjava适配器
//                .build();
//    }
//
//}

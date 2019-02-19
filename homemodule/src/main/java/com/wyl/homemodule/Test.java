package com.wyl.homemodule;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2019/2/14 14:46
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author WangYoule
 * @qq 270628297
 */
public class Test {
    public static void main() {
        Observable<String> observable2 = Observable.create(e -> {
            String name = Thread.currentThread().getName();
            System.out.println("observable2 = " + name);
            e.onNext(name + " a");
            e.onNext(name + " b");
            e.onNext(name + " c");
            e.onNext(name + " d");
            e.onComplete();
        });

        Observable<String> observable1 = Observable.create(e -> {
            String name = Thread.currentThread().getName();
            System.out.println("observable1 = " + name);
            e.onNext(name + " 1");
            e.onNext(name + " 2");
            e.onNext(name + " 3");
            e.onNext(name + " 4");
            e.onComplete();
        });

        Observable.concat(observable1, observable2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .firstOrError()
                .toObservable()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                        System.out.println("observer = " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

}

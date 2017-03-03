package com.example.a27459.juejin.base;

/**
 * Created by 27459 on 2017/3/1.
 */

public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}

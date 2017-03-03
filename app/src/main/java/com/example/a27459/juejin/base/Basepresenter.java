package com.example.a27459.juejin.base;

/**
 * Created by 27459 on 2017/3/1.
 */

public class Basepresenter<V> implements Presenter<V> {

    public V view;
    @Override
    public void attachView(V view) {
        this.view = view;
    }

    public Basepresenter(V view) {
        attachView(view);
    }

    @Override
    public void detachView() {
    }
}

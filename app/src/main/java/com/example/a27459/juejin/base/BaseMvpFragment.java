package com.example.a27459.juejin.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by 27459 on 2017/3/1.
 */

public abstract class BaseMvpFragment<P extends Basepresenter> extends BaseFragment {
    protected P mvpPresenter;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (mvpPresenter == null) mvpPresenter = createPresenter();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void lazyLoad() {
        if (mvpPresenter == null) mvpPresenter = createPresenter();
        super.lazyLoad();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mvpPresenter.detachView();
    }

    protected abstract P createPresenter();



}

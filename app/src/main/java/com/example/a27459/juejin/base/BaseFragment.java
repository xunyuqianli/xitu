package com.example.a27459.juejin.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 27459 on 2017/3/1.
 */

public abstract class BaseFragment extends Fragment {

    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return loadViewLayout(inflater, container);
    }

    protected abstract View loadViewLayout(LayoutInflater inflater, ViewGroup container);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        initView(view);
    }



    /**
     * 初始化界面
     */
    private void initView(View view) {
        bindView(view);
        processLogic();
        setListener();

    }

    /**
     * 设置监听
     */
    protected abstract void setListener();

    protected abstract void bindView(View view);

    /**
     * 数据懒加载
     */
    protected void lazyLoad(){

    }
    /**
     * 处理数据
     */
    protected abstract void processLogic();

}
